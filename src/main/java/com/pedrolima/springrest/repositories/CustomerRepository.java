package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pedrolima.springrest.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	//utilizado no validator automatico
	@Transactional(readOnly = true)
	Customer findByEmail(String email);
	
}
