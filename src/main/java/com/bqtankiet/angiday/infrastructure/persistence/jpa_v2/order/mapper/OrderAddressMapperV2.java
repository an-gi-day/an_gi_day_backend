package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderAddressV2;
import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderAddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderAddressMapperV2 {
    OrderAddressResponse toResponse(OrderAddressV2 addr);
}