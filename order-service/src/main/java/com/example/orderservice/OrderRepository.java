package com.example.orderservice;

import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.orderservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("select max(o.id) from Order o ")
	Integer getMaxOrderId();
}
