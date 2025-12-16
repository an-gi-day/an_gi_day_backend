package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderPaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaymentGatewayMapperV2.class})
public interface PaymentMapperV2 {
    OrderPaymentResponse toResponse(PaymentV2 payment);
}