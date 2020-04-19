package com.pedrolima.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedrolima.springrest.dto.CustomerDTO;
import com.pedrolima.springrest.dto.CustomerNewDTO;
import com.pedrolima.springrest.entities.Address;
import com.pedrolima.springrest.entities.City;
import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.entities.enums.CustomerType;
import com.pedrolima.springrest.repositories.CustomerRepository;
import com.pedrolima.springrest.services.exceptions.DataIntegrityException;
import com.pedrolima.springrest.services.exceptions.ResourceNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Customer findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found! Id: " + id));
	}

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer insert(CustomerNewDTO objDto) {
		Customer obj = fromDTO(objDto);
		return repository.save(obj);
	}

	public Customer update(CustomerDTO objDto) {
		Customer newObj = findById(objDto.getId());
		udpateDate(newObj, objDto);
		return repository.save(newObj);
	}

	public void deleteById(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Unable to delete Customer wich contains Orders");
		}
	}

	public Page<Customer> findPage(Integer page, Integer size, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Customer fromDTO(CustomerDTO objDto) {
		return new Customer(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}

	public Customer fromDTO(CustomerNewDTO objDto) {
		Customer obj = new Customer(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				CustomerType.toEnum(objDto.getType()));
		Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(),
				objDto.getNeighborhood(), objDto.getZipCode(), obj, new City(objDto.getCityId(), null, null));
		obj.getAddresses().add(address);
		obj.getPhones().add(objDto.getPhone1());
		if (objDto.getPhone2() != null) {
			obj.getPhones().add(objDto.getPhone2());
		}
		if (objDto.getPhone3() != null) {
			obj.getPhones().add(objDto.getPhone3());
		}
		return obj;
	}

	private void udpateDate(Customer newObj, CustomerDTO objDto) {
		newObj.setName(objDto.getName());
		newObj.setEmail(objDto.getEmail());
	}
}
