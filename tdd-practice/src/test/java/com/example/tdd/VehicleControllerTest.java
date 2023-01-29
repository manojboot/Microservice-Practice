package com.example.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VehicleController.class)
@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void getAllAvailableVehicle_Success() throws Exception {
	
		mockMvc.perform(get("/api/v1/vehicles")).andExpect(status().isOk());
	}
}
