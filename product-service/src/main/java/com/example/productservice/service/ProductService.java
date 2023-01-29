package com.example.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productservice.model.Product;
import com.example.productservice.model.ProductReponse;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.repository.ProductRepository;


@Service
public class ProductService {

	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public void addProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.productName(productRequest.getProductName())
				.productDescription(productRequest.getProductDescription())
				.price(productRequest.getPrice())
				.build();
		productRepository.save(product);
	}

	public List<ProductReponse> getAllProducts(){
		
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductReponse mapToProductResponse(Product product) {
		ProductReponse productReponse = ProductReponse.builder()
				.productId(product.getProductId())
				.productName(product.getProductName())
				.productDescription(product.getProductDescription())
				.price(product.getPrice())
				.build();	
		return productReponse;
	}
}
