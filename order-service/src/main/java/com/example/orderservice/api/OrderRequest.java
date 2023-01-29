package com.example.orderservice.api;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

	private List<OrderLineItemsRequest> orderLineItems;

}
