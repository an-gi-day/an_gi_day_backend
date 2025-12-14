package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderJpaEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@Mapper(componentModel = "spring")
public abstract class OrderJpaMapper implements JpaMapper<Order, OrderJpaEntity> {
    @Autowired
    protected OrderItemJpaMapper orderItemJpaMapper;

    @Mapping(target = "items", ignore = true)
    public abstract OrderJpaEntity modelToDto(Order model);

    @AfterMapping
    protected void afterMapping(@MappingTarget OrderJpaEntity entity, Order model) {
        if (model.getItems() != null) {
            model.getItems().stream()
                    .map(orderItemJpaMapper::modelToDto)
                    .forEach(entity::addItem);
        }
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(Instant.now());
        }
    }
}
