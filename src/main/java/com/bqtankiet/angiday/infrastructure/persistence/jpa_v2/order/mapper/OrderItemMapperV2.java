package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderItemResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderItemV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemOptionMapperV2.class})
public interface OrderItemMapperV2 {
    OrderItemResponse toResponse(OrderItemV2 item);
}