package com.example.inventoryservice;

import org.springframework.stereotype.Service;

import com.example.inventoryservice.api.InventoryRequest;
import com.example.inventoryservice.entity.Inventory;


@Service
public class InventoryService {

		private InventoryRepository inventoryRepository;
		
		public InventoryService(InventoryRepository inventoryRepository) {
			super();
			this.inventoryRepository = inventoryRepository;
		}

		public boolean isInStock(String skuCode) {
			
			return inventoryRepository.findBySkuCode(skuCode).isPresent();
		}
		
		public void addStock(InventoryRequest inventoryRequest) {
			
			Inventory inventory = new Inventory();
			inventory.setQuantity(inventoryRequest.getQuantity());
			inventory.setSkuCode(inventoryRequest.getSkuCode());
			inventoryRepository.save(inventory);
		}
}
