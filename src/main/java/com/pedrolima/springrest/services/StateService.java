package com.pedrolima.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrolima.springrest.entities.State;
import com.pedrolima.springrest.repositories.StateRepository;
import com.pedrolima.springrest.services.exceptions.ObjectNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;
	
	public List<State> findAllOrderByName() {
		return repository.findAllByOrderByName();
	}
	
	public State findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("State not found for id: " + id));
	}
}
