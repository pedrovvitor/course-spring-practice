package com.pedrolima.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrolima.springrest.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
