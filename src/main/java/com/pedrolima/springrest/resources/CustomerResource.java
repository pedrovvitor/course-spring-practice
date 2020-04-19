package com.pedrolima.springrest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedrolima.springrest.dto.CustomerDTO;
import com.pedrolima.springrest.dto.CustomerNewDTO;
import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id){
		Customer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Customer> insert(@Valid @RequestBody CustomerNewDTO objDto) {
		Customer obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<Customer> list = service.findAll();
		List<CustomerDTO> listDto = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<CustomerDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24")Integer size,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		Page<Customer> list = service.findPage(page, size, orderBy, direction);
		Page<CustomerDTO> listDto = list.map(obj -> new CustomerDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id,@Valid @RequestBody CustomerDTO objDto) {
		objDto.setId(id);
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
