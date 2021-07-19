package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.exception.OrderNotFoundException;
import com.pathz.boot.rest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        String errorMessage = String.format("%s%d%s", "Order with id", id, " not found");
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(errorMessage));
    }
}
