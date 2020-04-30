package com.pedrolima.springrest.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.pedrolima.springrest.entities.PaymentSlip;

@Service
public class PaymentSlipService {

	public static void fillPaymentSlip(PaymentSlip payment, LocalDateTime instant) {
		payment.setExpirationDate(instant.plusDays(7).toLocalDate());
		
	}

}
