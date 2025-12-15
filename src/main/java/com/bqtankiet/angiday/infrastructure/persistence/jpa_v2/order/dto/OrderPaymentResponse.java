package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentGatewayResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentMethod;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderPaymentResponse {
    private Long id;
    private PaymentMethod method;
    private PaymentStatus status;
    private PaymentGatewayResponse gateway;
    private Instant createdAt;
}