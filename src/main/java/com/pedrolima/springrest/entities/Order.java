package com.pedrolima.springrest.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime instant;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "deliveryAddress_id")
	private Address deliveryAddress;
	
	@OneToMany(mappedBy = "id.order")
	private Set<ItemOrder> itens = new HashSet<ItemOrder>();

	public Order() {
	}

	public Order(Long id, LocalDateTime instant, Customer customer, Address deliveryAddress) {
		super();
		this.id = id;
		this.instant = instant;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
	}
	
	public double getTotalValue() {
		return itens.parallelStream().mapToDouble((item) -> item.getSubTotal()).sum();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInstant() {
		return instant;
	}

	public void setInstant(LocalDateTime instant) {
		this.instant = instant;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Set<ItemOrder> getItens() {
		return itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		StringBuilder builder = new StringBuilder();
		builder.append("Order number: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(getInstant().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		builder.append(", Customer: ");
		builder.append(getCustomer().getName());
		builder.append(", Payment status: ");
		builder.append(getPayment().getState().getDescription());
		builder.append("\nDetails:\n");
		builder.append(getItens().stream().map((item) -> item.toString()).collect(Collectors.joining()));
		builder.append("Total Value: ");
		builder.append(nf.format(getTotalValue()));
		return builder.toString();
	}

	
}
