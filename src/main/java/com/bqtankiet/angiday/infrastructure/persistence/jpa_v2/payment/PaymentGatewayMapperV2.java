package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentGatewayMapperV2 {
    PaymentGatewayResponseV2 toResponse(PaymentGatewayV2 gateway);
}