package com.example.productservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductReponse {

	private int productId;
	private String productName;
	private String productDescription;
	private double price;
}
