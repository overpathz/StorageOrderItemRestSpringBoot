package com.pathz.boot.rest.controller;

import com.pathz.boot.rest.dto.OrderRequestDTO;
import com.pathz.boot.rest.dto.OrderResponseDTO;
import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.service.OrderServiceInterface;
import com.pathz.boot.rest.util.OrderMapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceInterface orderService;

    @Autowired
    OrderMapperDTO orderMapperDTO;

    @GetMapping("")
    public List<OrderResponseDTO> getAll() {
        orderService.deleteTimeOutOrder();

        List<OrderResponseDTO> orders = orderService
                .findAll()
                .stream()
                .map(order -> orderMapperDTO.mapOrderToDTO(order))
                .collect(Collectors.toList());

        return orders;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Order order = orderMapperDTO.mapDTOtoOrder(orderRequestDTO);
        order.setCreatedAt(LocalDateTime.now());
        return orderService.save(order);
    }

}
