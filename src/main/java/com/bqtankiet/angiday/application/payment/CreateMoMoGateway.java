package com.bqtankiet.angiday.application.payment;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;
import com.bqtankiet.angiday.domain.payment.PaymentGatewayProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMoMoGateway {
    private PaymentGatewayProvider paymentGatewayService;

    @Autowired
    public CreateMoMoGateway(PaymentGatewayProvider paymentGatewayService) {
        this.paymentGatewayService = paymentGatewayService;
    }

    public PaymentGateway execute(Order order) {
        return paymentGatewayService.getPaymentGateway(order);
    }
}
