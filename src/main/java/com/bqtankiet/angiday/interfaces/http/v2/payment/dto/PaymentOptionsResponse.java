package com.bqtankiet.angiday.interfaces.http.v2.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaymentOptionsResponse {
    private List<PaymentGatewayResponse> gateways;
}