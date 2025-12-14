package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderItemJpaEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderItemJpaMapper extends JpaMapper<OrderItem, OrderItemJpaEntity> {

}