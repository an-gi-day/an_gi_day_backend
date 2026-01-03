package com.bqtankiet.angiday.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Payment () {
        this.paymentMethod = "cash";
        this.paymentStatus = "DRAFT";
    }

    public boolean isValid() {
        return paymentStatus != null;
    }
}
