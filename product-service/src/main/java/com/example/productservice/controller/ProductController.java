package com.example.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.model.ProductReponse;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.service.ProductService;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	private ProductService productService;
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Movie Catalogue";
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public void addMovie(@RequestBody ProductRequest productRequest) {
		
		productService.addProduct(productRequest);

	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/movies")
	public List<ProductReponse> getAllMovies() {
		
		return productService.getAllProducts();

	}
}
