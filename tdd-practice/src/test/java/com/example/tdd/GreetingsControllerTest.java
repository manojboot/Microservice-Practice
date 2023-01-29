package com.example.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTest {

		@Autowired
		MockMvc mockMvc;
		
		@org.junit.jupiter.api.Test
		void testGreetings200Response() throws Exception {
			
			String name = "Manoj";
			String gender = "male";
			mockMvc.perform(
					get("/api/v1/greetings").contentType(MediaType.APPLICATION_JSON)
					.param("name", name)
				).andExpect(status().isOk());
		}
}
