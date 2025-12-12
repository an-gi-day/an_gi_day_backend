package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.Order;

import java.util.Optional;

public interface IOrderRepository {

    Optional<Order> findById(String id);
    Optional<Order> createOrder(Order order);
    Optional<Order> updateOrder(Order order);

}
