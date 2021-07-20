package com.pathz.boot.rest.controller;

import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.service.OrderServiceImpl;
import com.pathz.boot.rest.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceInterface orderServiceInterface;

    @PostMapping("")
    public Order addOrder(@RequestBody Order order) {
        return orderServiceInterface.save(order);
    }
    
}
