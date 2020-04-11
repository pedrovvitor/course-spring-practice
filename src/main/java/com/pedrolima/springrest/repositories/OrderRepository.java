package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrolima.springrest.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
