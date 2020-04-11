package com.pedrolima.springrest.entities.enums;

public enum PaymentState {

	PENDING(1, "Pending"),
	PAYED(2, "Payed"),
	CANCELLED(3, "Cancelled");
	
	private Integer cod;
	private String description;
	
	private PaymentState(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public PaymentState toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(PaymentState x : PaymentState.values()) {
			if(x.getCod() == cod) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Id: " + cod);
	}
}
