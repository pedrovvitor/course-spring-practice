package com.pedrolima.springrest.resources.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

	public static List<Long> decodeLongList(String value){
		return Arrays
				.asList(value.split(","))
				.stream()
				.map((s) -> Long.parseLong(s))
				.collect(Collectors.toList());
	}
}
