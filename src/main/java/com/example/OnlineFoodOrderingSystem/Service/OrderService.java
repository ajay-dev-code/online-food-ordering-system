package com.example.OnlineFoodOrderingSystem.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrderingSystem.Entity.Order;
import com.example.OnlineFoodOrderingSystem.Entity.OrderStatus;
import com.example.OnlineFoodOrderingSystem.Repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {

        order.setStatus(OrderStatus.PENDING);
        order.setOrderTime(LocalDateTime.now());
        
        if(order.getTotalamount() == null){
            order.setTotalamount(0.0);
        }

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}