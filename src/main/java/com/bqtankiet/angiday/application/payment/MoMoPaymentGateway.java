package com.bqtankiet.angiday.application.payment;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;

public class MoMoPaymentGateway extends PaymentGateway {
    public MoMoPaymentGateway(Order order) {
        this.name = "momo";
        this.webUrl = "https://test-payment.momo.vn/v2/gateway/pay?t=TU9NT0JLVU4yMDE4MDUyOXxPRDE3NjU4NzYyODE5Nzk&s=91024508a6f5f541288902a67b0c5e556e155cd4e6d9c82ac00f92691078538c";
        this.appUrl = "momo://app?action=payWithApp&isScanQR=false&serviceType=app&sid=TU9NT0JLVU4yMDE4MDUyOXxPRDE3NjU4NzYyODE5Nzk&v=3.0";
    }

}
