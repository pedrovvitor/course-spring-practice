package com.pedrolima.springrest.entities.enums;

import java.util.Arrays;

public enum Profile {

	ADMIN(1, "ROLE_ADMIN"),
	USER(2, "ROLE_USER");
	
	private int id;
	private String description;

	private Profile(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Profile toEnum(Integer cod) {
		if( cod == null) {
			return null;
		}
		return Arrays.stream(Profile.values())
				.filter((x) -> cod.equals(x.getId()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id" + cod));
	}
}
	
