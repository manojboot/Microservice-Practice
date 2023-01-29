package com.example.inventoryservice.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryRequest {

	private Long id;
	private String skuCode;
	private Integer quantity;
}
