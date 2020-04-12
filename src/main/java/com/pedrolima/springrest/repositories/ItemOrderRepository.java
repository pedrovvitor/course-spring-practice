package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrolima.springrest.entities.ItemOrder;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long>{

}
