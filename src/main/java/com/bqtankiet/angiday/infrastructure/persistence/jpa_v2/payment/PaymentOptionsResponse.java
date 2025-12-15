package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaymentOptionsResponse {
    private List<PaymentGatewayResponse> gateways;
}