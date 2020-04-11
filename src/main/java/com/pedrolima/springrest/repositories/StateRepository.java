package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.springrest.entities.State;

public interface StateRepository extends JpaRepository<State, Long>{

}
