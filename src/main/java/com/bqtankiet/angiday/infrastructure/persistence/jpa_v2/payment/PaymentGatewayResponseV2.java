package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentGatewayResponseV2 {
    private Long id;
    private String name;
    private String appUrl;
    private String webUrl;
}