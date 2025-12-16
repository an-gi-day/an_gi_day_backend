package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.OrderItemPricing;

import java.util.Optional;

public interface IOrderItemPricingRepository {

    Optional<OrderItemPricing> findById(String id);
    Optional<OrderItemPricing> createItemPricing(OrderItemPricing pricing);
    Optional<OrderItemPricing> updateItemPricing(OrderItemPricing pricing);

}
