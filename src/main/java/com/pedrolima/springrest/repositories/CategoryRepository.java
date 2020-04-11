package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrolima.springrest.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
