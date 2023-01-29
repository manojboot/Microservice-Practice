package com.example.orderservice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.orderservice.api.Inventory;
import com.example.orderservice.api.OrderCreatedEvent;
import com.example.orderservice.api.OrderLineItemsRequest;
import com.example.orderservice.api.OrderRequest;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderLineItems;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

	private OrderRepository orderRepository;
	private WebClient webClient;
	private KafkaTemplate<String,OrderCreatedEvent> kafkaTemplate;
	public OrderService(OrderRepository orderRepository,WebClient webClient,KafkaTemplate<String,OrderCreatedEvent> kafkaTemplate) {
		super();
		this.orderRepository = orderRepository;
		this.webClient = webClient;
		this.kafkaTemplate = kafkaTemplate;
	}


	public void placeOrder(OrderRequest orderRequest) {
		
		Integer maxId = orderRepository.getMaxOrderId();
		int id;
		if(maxId!=null) {
			id = maxId + 1;
		}else {
			id = 1;
		}
		int currentYear = LocalDate.now().getYear();
		StringBuffer orderId = new StringBuffer();
		orderId.append("ODR-").append(currentYear).append("-0000").append(id);
		Order order = new Order();
		order.setOrderNumber(orderId.toString());
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItems()
									.stream()
									.map(this::mapToOrderLineItems).collect(Collectors.toList());
		order.setOrderLineItems(orderLineItems);
		
		String skucode = orderLineItems.get(0).getSkuCode();
		// Communicating with inventory service to check the inventory availability using Resttemplate or using WebCleint
		
		
		Boolean currentInventory =  webClient.get().uri("http://localhost:9393/api/v1/inventory/stock",
									uriBuilder->uriBuilder.queryParam("skuCode", skucode).build(skucode))
						.retrieve()
						.bodyToMono(Boolean.class)
						.block();
		if(currentInventory) {
			orderRepository.save(order);
			kafkaTemplate.send("ORDER_CREATED", new OrderCreatedEvent(order.getOrderNumber()));
			log.info("Order created successfully {0}" +order.getOrderNumber());
		}else {
			throw new IllegalArgumentException("Product is not in Stock. Please try after sometime");
		}
		
	}
	
	
	private OrderLineItems mapToOrderLineItems(OrderLineItemsRequest orderLineItemsRequest){
		
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setId(orderLineItemsRequest.getId());
		orderLineItems.setSkuCode(orderLineItemsRequest.getSkuCode());
		orderLineItems.setPrice(orderLineItemsRequest.getPrice());
		orderLineItems.setQuantity(orderLineItemsRequest.getQuantity());
		return orderLineItems;
	}
}
