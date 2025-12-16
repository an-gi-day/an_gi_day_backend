package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentGatewayJpaEntityV2;
import com.bqtankiet.angiday.interfaces.http.v2.payment.dto.PaymentGatewayResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentGatewayJpaMapperV2 {
    PaymentGatewayResponse toResponse(PaymentGatewayJpaEntityV2 gateway);
}