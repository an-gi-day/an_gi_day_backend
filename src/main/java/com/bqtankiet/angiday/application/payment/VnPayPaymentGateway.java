package com.bqtankiet.angiday.application.payment;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;

public class VnPayPaymentGateway extends PaymentGateway {
    public VnPayPaymentGateway(Order order) {
        this.name = "vnpay";
        this.appUrl = "app://vnpay";
        this.webUrl = "web://vnpay";
    }
}
