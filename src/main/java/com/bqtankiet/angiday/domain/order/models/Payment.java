package com.bqtankiet.angiday.domain.order.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    private String id;
    private String paymentMethod;
    private String paymentStatus;
    private PaymentGateway gateway;

    public static Payment create(String paymentMethod) {
        PaymentGateway gateway = PaymentGateway.create(paymentMethod);
        return new Payment(null, paymentMethod, "Awaiting", gateway);
    }

}
