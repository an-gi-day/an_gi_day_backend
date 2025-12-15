package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentGatewayMapper {
    PaymentGatewayResponse toResponse(PaymentGateway gateway);
}