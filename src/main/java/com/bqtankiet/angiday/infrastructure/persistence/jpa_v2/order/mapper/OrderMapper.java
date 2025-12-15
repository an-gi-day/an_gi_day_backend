package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.Order;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        OrderItemMapper.class,
        OrderAddressMapper.class,
        PaymentMapper.class,
        VoucherMapper.class
})
public interface OrderMapper {
    OrderResponse toResponse(Order order);
}