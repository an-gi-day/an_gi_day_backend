package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentMapperV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        OrderItemMapperV2.class,
        OrderAddressMapperV2.class,
        PaymentMapperV2.class,
        VoucherMapperV2.class
})
public interface OrderMapperV2 {
    OrderResponse toResponse(OrderV2 order);
}