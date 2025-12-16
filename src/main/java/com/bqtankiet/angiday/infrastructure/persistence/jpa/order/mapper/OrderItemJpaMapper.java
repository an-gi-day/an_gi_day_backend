package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderItemJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",
        uses = {OrderItemOptionJpaMapper.class,
                OrderItemPricingJpaMapper.class,})
public interface OrderItemJpaMapper extends
        DomainEntityMapper<OrderItem, OrderItemJpaEntity> {

    @Override
//    @Mapping(target = "food", ignore = true)
    OrderItem toDomain(OrderItemJpaEntity orderItemJpaEntity);

    @Override
    OrderItemJpaEntity toEntity(OrderItem orderItem);
}