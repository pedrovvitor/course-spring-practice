package com.pedrolima.springrest.entities;

import java.time.LocalDate;

import com.pedrolima.springrest.entities.enums.PaymentState;

public class PaymentSlip extends Payment {
	private static final long serialVersionUID = 1L;
	
	private LocalDate expirationDate;
	private LocalDate paymentDate;
	
	public PaymentSlip() {
	}
	public PaymentSlip(Long id, PaymentState state, Order order, LocalDate expirationDate, LocalDate paymentDate) {
		super(id, state, order);
		this.expirationDate = expirationDate;
		this.paymentDate = paymentDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
