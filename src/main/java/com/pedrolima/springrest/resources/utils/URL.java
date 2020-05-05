package com.pedrolima.springrest.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeParam(String value) {
		try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static List<Long> decodeLongList(String value) {
		try {
			return Arrays
					.asList(value.split(","))
					.stream()
					.map((s) -> Long.parseLong(s))
					.collect(Collectors.toList());
		} catch (Exception e) {
			return null;
		}
	}
}
