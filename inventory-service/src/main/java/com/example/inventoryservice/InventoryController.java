package com.example.inventoryservice;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventoryservice.api.InventoryRequest;



@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
	
		private InventoryService inventoryService;
		
		public InventoryController(InventoryService inventoryService) {
			super();
			this.inventoryService = inventoryService;
		}

		@ResponseStatus(HttpStatus.OK)
		@GetMapping("/stock")
		public boolean isInStock(@RequestParam(defaultValue = StringUtils.EMPTY) String skuCode) {
			
			return inventoryService.isInStock(skuCode);
			
		}
		
		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping("/add")
		public void addStock(@RequestBody InventoryRequest inventoryRequest) {
			
			 inventoryService.addStock(inventoryRequest);
		}
}
