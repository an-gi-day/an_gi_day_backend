package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentJpaEntityV2;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderPaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaymentGatewayJpaMapperV2.class})
public interface PaymentMapperV2 {
    OrderPaymentResponse toResponse(PaymentJpaEntityV2 payment);
}