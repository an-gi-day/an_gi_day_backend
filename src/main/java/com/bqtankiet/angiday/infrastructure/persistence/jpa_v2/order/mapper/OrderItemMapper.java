package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderItemResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemOptionMapper.class})
public interface OrderItemMapper {
    OrderItemResponse toResponse(OrderItem item);
}