package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.OrderItemOption;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderItemOptionJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemOptionJpaMapper
        extends DomainEntityMapper<OrderItemOption, OrderItemOptionJpaEntity> {
}
