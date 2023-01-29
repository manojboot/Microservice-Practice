package com.example.tdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/todos")
	ResponseEntity<List<City>> findAll() {
		return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
	}

}
