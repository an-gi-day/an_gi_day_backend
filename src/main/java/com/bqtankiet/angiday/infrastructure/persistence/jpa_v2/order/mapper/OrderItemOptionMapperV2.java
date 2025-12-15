package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderItemOptionV2;
import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderItemOptionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemOptionMapperV2 {
    OrderItemOptionResponse toResponse(OrderItemOptionV2 option);
}