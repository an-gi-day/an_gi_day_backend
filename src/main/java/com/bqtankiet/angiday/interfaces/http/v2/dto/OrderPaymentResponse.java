package com.bqtankiet.angiday.interfaces.http.v2.dto;

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
    private PaymentGatewayResponse gateway;
    private Instant createdAt;
}