package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.OrderItemOption;

import java.util.Optional;

public interface IOrderItemOptionRepository {

    Optional<OrderItemOption> findById(String id);
    Optional<OrderItemOption> createItemOption(OrderItemOption option);
    Optional<OrderItemOption> updateItemOption(OrderItemOption option);

}
