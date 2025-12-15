package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderPaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaymentGatewayMapper.class})
public interface PaymentMapper {
    OrderPaymentResponse toResponse(Payment payment);
}