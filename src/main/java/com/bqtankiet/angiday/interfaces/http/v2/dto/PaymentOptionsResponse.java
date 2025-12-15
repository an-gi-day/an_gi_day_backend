package com.bqtankiet.angiday.interfaces.http.v2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaymentOptionsResponse {
    private List<PaymentGatewayResponse> gateways;
}