package com.bqtankiet.angiday.interfaces.http.v2.order.mapper;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderItemResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderItemResponseMapper implements DomainDtoMapper<OrderItem, OrderItemResponse>  {
}
