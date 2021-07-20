package com.pathz.boot.rest.repository;

import com.pathz.boot.rest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCreatedAtBefore(LocalDateTime time);
}
