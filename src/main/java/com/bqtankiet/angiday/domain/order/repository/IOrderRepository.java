package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.Order;

import java.util.Optional;

public interface IOrderRepository {

    Optional<Order> findById(Long id);
    Optional<Order> updateOrder(Order order);

    Optional<Order> saveOrder(Order order);

    void removeOrderByUserIdAndStatus(Long userId, String draft);
}
