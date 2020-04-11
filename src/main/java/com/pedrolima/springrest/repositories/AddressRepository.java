package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.springrest.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
