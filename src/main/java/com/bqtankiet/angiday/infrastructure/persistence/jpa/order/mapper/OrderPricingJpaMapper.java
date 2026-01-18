package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.OrderPricing;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderPricingJpaEmbed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderPricingJpaMapper extends DomainEntityMapper<OrderPricing, OrderPricingJpaEmbed> {
}
