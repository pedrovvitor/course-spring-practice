package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrolima.springrest.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
