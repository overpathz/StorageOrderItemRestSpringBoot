package com.pathz.boot.rest.service_layer;



import com.pathz.boot.rest.entity.Item;
import com.pathz.boot.rest.entity.Order;
import com.pathz.boot.rest.repository.OrderRepository;
import com.pathz.boot.rest.service.OrderServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void init() {

    }

    @Test
    public void save() {
        Item item = new Item(1, "Computer", 550, 3);
        Order order = new Order(1, 32, 2, LocalDateTime.now(), item);

        orderService.save(order);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void findAll() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> orderList = orderService.findAll();

        Assert.assertEquals(orders, orderList);
    }

    @Test
    public void deleteTimedOutObject() {

    }
}
