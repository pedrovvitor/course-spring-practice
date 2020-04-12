package com.pedrolima.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrolima.springrest.entities.Order;
import com.pedrolima.springrest.repositories.OrderRepository;
import com.pedrolima.springrest.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found! Id: " + id));
	}
}
