package com.bqtankiet.angiday.interfaces.http.v2.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentGatewayResponse {
    private Long id;
    private String name;
    private String appUrl;
    private String webUrl;
}