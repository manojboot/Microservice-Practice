package com.example.tdd;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetingsController {

	
	@GetMapping("/greetings")
	public ResponseEntity<String> greetings(@RequestParam("name")String name) {
		
		return new ResponseEntity<>(
					String.format("Hello Mr How are your", name),
					HttpStatus.OK
				);
	}
}
