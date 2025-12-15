package com.bqtankiet.angiday.domain.order.models;

import lombok.Data;

import java.util.Map;

@Data
public class PaymentGateway {
    private Long id;
    private String name;
    private String transactionId;
    private String appUrl;
    private String webUrl;
    private Map<String, Object> extraData;

}
