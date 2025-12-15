package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import com.bqtankiet.angiday.interfaces.http.v2.dto.PaymentGatewayResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentGatewayMapperV2 {
    PaymentGatewayResponse toResponse(PaymentGatewayV2 gateway);
}