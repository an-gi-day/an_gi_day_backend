package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.ItemPricing;

import java.util.Optional;

public interface IItemPricingRepository {

    Optional<ItemPricing> findById(String id);
    Optional<ItemPricing> createItemPricing(ItemPricing pricing);
    Optional<ItemPricing> updateItemPricing(ItemPricing pricing);

}
