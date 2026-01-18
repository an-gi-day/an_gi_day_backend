package com.bqtankiet.angiday.domain.payment;

import com.bqtankiet.angiday.domain.order.models.Order;

public interface PaymentGatewayProvider {

    public PaymentGateway getPaymentGateway(Order order);

}
