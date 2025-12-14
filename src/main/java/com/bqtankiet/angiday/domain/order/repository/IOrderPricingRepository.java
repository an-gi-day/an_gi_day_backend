package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.OrderPricing;

import java.util.Optional;

public interface IOrderPricingRepository {

    Optional<OrderPricing> findById(String id);
    Optional<OrderPricing> createOrderPricing(OrderPricing pricing);
    Optional<OrderPricing> updateOrderPricing(OrderPricing pricing);

}
