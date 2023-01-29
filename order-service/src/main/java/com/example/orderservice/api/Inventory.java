package com.example.orderservice.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {

	private Long id;
	private String skuCode;
	private Integer quantity;

}
