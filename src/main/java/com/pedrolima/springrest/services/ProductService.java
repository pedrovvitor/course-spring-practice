package com.pedrolima.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrolima.springrest.entities.Product;
import com.pedrolima.springrest.repositories.ProductRepository;
import com.pedrolima.springrest.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found! Id: " + id));
	}
}
