package com.example.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

	
	@GetMapping("vehicle")
	public String getAvailableVehicles() {
	
		return new String();
	}
}
