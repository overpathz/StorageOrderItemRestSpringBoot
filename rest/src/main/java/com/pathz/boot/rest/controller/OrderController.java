package com.pathz.boot.rest.controller;

import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }



}
