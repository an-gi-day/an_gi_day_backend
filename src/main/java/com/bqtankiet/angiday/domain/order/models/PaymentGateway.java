package com.bqtankiet.angiday.domain.order.models;

import lombok.Data;

import java.util.Map;

@Data
public class PaymentGateway {
    private String id;
    private String name;
    private String transactionId;
    private String redirectUrl;
    private Map<String, Object> extraData;

    public static PaymentGateway create(String paymentMethod) {
        if ("cash".equalsIgnoreCase(paymentMethod)) {return null;}
        return null; // FIXME: Ignore return error.
    }
}
