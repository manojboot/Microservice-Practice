package com.example.orderservice.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineItemsRequest {

	private Long id;
	private String skuCode;
	private double price;
	private int quantity;
}
