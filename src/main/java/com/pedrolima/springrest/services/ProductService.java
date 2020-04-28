package com.pedrolima.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedrolima.springrest.entities.Category;
import com.pedrolima.springrest.entities.Product;
import com.pedrolima.springrest.repositories.ProductRepository;
import com.pedrolima.springrest.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryService catService;
	
	public Product findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found! Id: " + id));
	}
		
	public Page<Product> search(String name, List<Long> ids, Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = new ArrayList<>();
		for(Long id : ids) {
			categories.add(catService.findById(id));
		}
		return repository.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
	}
}
