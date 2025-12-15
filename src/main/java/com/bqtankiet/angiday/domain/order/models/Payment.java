package com.bqtankiet.angiday.domain.order.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    private Long id;
    private String paymentMethod;
    private String paymentStatus;
    private PaymentGateway gateway;

    public static Payment create(String paymentMethod) {
        return new Payment(null, paymentMethod, "Awaiting", null);
    }

}
