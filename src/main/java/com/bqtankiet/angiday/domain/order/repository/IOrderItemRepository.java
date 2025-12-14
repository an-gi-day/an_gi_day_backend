package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.OrderItem;

import java.util.Optional;

public interface IOrderItemRepository {

    Optional<OrderItem> findById(String id);
    Optional<OrderItem> createOrderItem(OrderItem item);
    Optional<OrderItem> updateOrderItem(OrderItem item);

}
