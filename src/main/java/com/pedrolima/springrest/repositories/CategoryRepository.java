package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.springrest.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
