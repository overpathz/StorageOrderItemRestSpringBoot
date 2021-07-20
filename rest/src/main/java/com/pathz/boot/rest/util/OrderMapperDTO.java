package com.pathz.boot.rest.util;

import com.pathz.boot.rest.dto.OrderRequestDTO;
import com.pathz.boot.rest.dto.OrderResponseDTO;
import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.service.ItemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperDTO {

    @Autowired
    private ItemServiceInterface itemService;

    public Order mapDTOtoOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();

        order.setItem(itemService.findById(orderRequestDTO.getItemId()));
        order.setPrice(orderRequestDTO.getPrice());
        order.setQuantity(orderRequestDTO.getQuantity());

        return order;
    }

    public OrderResponseDTO mapOrderToDTO(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setItem(order.getItem().getName());
        orderResponseDTO.setPrice(order.getPrice());
        orderResponseDTO.setQuantity(order.getQuantity());

        return orderResponseDTO;
    }

}
