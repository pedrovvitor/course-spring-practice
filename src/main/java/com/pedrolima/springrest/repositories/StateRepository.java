package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrolima.springrest.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
