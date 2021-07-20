package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Order;

import java.util.List;

public interface OrderServiceInterface {
    Order save(Order item);
    List<Order> findAll(Order id);
    void deleteTimeOutOrder();
}
