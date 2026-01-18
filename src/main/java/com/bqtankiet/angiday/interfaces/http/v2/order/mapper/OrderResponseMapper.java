package com.bqtankiet.angiday.interfaces.http.v2.order.mapper;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderResponseMapper implements DomainDtoMapper<Order, OrderResponse> {

}
