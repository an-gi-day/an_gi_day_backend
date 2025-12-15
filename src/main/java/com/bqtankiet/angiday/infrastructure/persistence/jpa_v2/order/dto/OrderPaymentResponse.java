package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentGatewayResponseV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentMethodV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.PaymentStatusV2;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderPaymentResponse {
    private Long id;
    private PaymentMethodV2 method;
    private PaymentStatusV2 status;
    private PaymentGatewayResponseV2 gateway;
    private Instant createdAt;
}