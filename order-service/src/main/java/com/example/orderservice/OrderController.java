package com.example.orderservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.api.OrderRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v1/orderservice")
public class OrderController {

	private OrderService orderService;
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping("/create")
//	@CircuitBreaker(name = "inventory")
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		
		orderService.placeOrder(orderRequest);
		return "Order Plced Successfully {} ";
	}
	
//	public String fallBackForPlaceOrder(OrderRequest orderRequest,RuntimeException runtimeException) {
//		
//		return "There seems to be issue in creating order,Please try after sometime";
//	}
}
