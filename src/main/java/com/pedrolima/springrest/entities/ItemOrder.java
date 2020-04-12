package com.pedrolima.springrest.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item_order")
public class ItemOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemOrderPk id = new ItemOrderPk();
	
	private Double discount;
	
	private Integer quantity;
	
	private Double price;
	
	public ItemOrder() {
		super();
	}

	public ItemOrder(Product product, Order order, Double discount, Integer quantity, Double price) {
		super();
		id.setProduct(product);
		id.setOrder(order);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public ItemOrderPk getId() {
		return id;
	}

	public void setId(ItemOrderPk id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
