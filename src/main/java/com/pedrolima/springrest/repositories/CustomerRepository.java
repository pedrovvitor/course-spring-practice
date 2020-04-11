package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.springrest.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
