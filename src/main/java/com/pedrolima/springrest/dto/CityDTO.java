package com.pedrolima.springrest.dto;

import java.io.Serializable;

import com.pedrolima.springrest.entities.City;

public class CityDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	public CityDTO() {
	}
	
	public CityDTO(City obj) {
		id = obj.getId();
		name = obj.getName();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
