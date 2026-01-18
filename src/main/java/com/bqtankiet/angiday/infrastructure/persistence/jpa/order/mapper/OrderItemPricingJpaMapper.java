package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.OrderItemPricing;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderItemPricingJpaEmbed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemPricingJpaMapper extends
        DomainEntityMapper<OrderItemPricing, OrderItemPricingJpaEmbed> {
}