package com.example.tdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> findAll() {
		
		return cityRepository.findAll();
	}


}