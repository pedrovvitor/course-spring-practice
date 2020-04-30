package com.pedrolima.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pedrolima.springrest.entities.enums.PaymentState;

@Entity
@Table(name = "tb_credit_card_payment")
@JsonTypeName("pagamentoComCartao")
public class CreditCardPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer installments;

	public CreditCardPayment() {
	}

	public CreditCardPayment(Long id, PaymentState state, Order order, Integer installments) {
		super(id, state, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

}
