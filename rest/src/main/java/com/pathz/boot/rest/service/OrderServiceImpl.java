package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderServiceInterface {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order item) {
        return orderRepository.save(item);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteTimeOutOrder() {
        LocalDateTime currentTime = LocalDateTime.now();

        orderRepository.deleteAll(
                orderRepository.findByCreatedAtBefore(currentTime.minusMinutes(1))
        );
    }
}