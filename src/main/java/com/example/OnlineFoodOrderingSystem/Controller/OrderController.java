package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OnlineFoodOrderingSystem.Entity.Order;
import com.example.OnlineFoodOrderingSystem.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderservice;

	public OrderController(OrderService orderservice) {
		this.orderservice = orderservice;
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {

		return ResponseEntity.ok(orderservice.createOrder(order));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {

		return ResponseEntity.ok(orderservice.getUserOrders(userId));
	}

	@PutMapping("/cancel/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {

		orderservice.cancelOrder(orderId);
		return ResponseEntity.ok("Order cancelled successfully");
	}
}