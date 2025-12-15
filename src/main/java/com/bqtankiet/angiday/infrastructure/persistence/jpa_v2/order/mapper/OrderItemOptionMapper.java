package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderItemOption;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderItemOptionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemOptionMapper {
    OrderItemOptionResponse toResponse(OrderItemOption option);
}