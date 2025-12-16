package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentMethodJpaEntityV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentStatusJpaEntityV2;
import com.bqtankiet.angiday.interfaces.http.v2.payment.dto.PaymentGatewayResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderPaymentResponse {
    private Long id;
    private PaymentMethodJpaEntityV2 method;
    private PaymentStatusJpaEntityV2 status;
    private PaymentGatewayResponse gateway;
    private Instant createdAt;
}