package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.springrest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
