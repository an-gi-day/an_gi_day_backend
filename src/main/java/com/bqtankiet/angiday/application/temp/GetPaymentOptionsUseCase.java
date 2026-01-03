package com.bqtankiet.angiday.application.temp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPaymentOptionsUseCase {

    private final List<PaymentOption> paymentOptions;

    GetPaymentOptionsUseCase() {
        this.paymentOptions = List.of(
                new PaymentOption("cash", "cash"),
                new PaymentOption("momo", "gateway"),
                new PaymentOption("vnpay", "gateway"));
    }

    public List<PaymentOption> call(){
        return paymentOptions;
    }

    public boolean isValidMethod(String paymentMethod) {
        return paymentOptions.stream().anyMatch(option -> paymentMethod.equalsIgnoreCase(option.getMethod()));
    }
}
