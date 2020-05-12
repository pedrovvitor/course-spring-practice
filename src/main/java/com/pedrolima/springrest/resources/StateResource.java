package com.pedrolima.springrest.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrolima.springrest.dto.CityDTO;
import com.pedrolima.springrest.dto.StateDTO;
import com.pedrolima.springrest.entities.State;
import com.pedrolima.springrest.services.CityService;
import com.pedrolima.springrest.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateResource {
	
	@Autowired
	private StateService service;
	
	@Autowired
	private CityService cityService;

	@GetMapping
	public ResponseEntity<List<StateDTO>>findAll() {
		List<State> list = service.findAllOrderByName();
		List<StateDTO> listDto = list.stream().map(obj -> new StateDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<State> findStateById(@PathVariable Long id){
		State obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}/cities")
	public ResponseEntity<List<CityDTO>> findCities(@PathVariable Long id){
		State obj = service.findById(id);
		List<CityDTO>listDto = cityService.findCities(obj);
		return ResponseEntity.ok().body(listDto);
	}
	
}
