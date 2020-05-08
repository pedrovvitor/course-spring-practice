package com.pedrolima.springrest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Transactional(readOnly = true)
	Page<Order> findByCustomer(Customer customer, Pageable pageRequest);
}
