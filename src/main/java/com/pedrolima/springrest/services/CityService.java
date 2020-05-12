package com.pedrolima.springrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pedrolima.springrest.dto.CityDTO;
import com.pedrolima.springrest.entities.State;

@Service
public class CityService {

	
	public List<CityDTO> findCities(State state) {
		List<CityDTO> listDto = state.getCities().stream().map((city) -> new CityDTO(city)).collect(Collectors.toList());
		return listDto;
	}
}
