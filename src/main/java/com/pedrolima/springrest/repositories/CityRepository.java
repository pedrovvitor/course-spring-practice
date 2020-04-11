package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.springrest.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
