package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderAddress;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderAddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderAddressMapper {
    OrderAddressResponse toResponse(OrderAddress addr);
}