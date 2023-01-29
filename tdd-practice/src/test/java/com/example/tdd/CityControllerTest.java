package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CityControllerTest {

	@InjectMocks
	private CityController cityController;
	@Mock
	private CityService cityService;
	
	@Test
	void shouldReturnCityDetailsList() {
		List<City> cities = new ArrayList<City>();
		cities.add(new City(1,"Joshimath","IND","Chamoli",120000));
		cities.add(new City(1,"Haldwani","IND","Nanital",120000));
		ResponseEntity<List<City>> response = cityController.findAll();
		assertNotNull(response);
	}
}
