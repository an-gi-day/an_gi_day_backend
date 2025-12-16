package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.application.payment.MoMoPaymentGateway;
import com.bqtankiet.angiday.application.payment.VnPayPaymentGateway;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.Payment;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmOrderUseCase {

    private final SaveOrderUseCase saveOrderUseCase;

    public Order execute(Order order) {
        if (!order.isValid()) {
            return order;
        }
        Payment payment = order.getPayment();
        PaymentGateway paymentGateway = createPaymentGateway(payment.getPaymentMethod(), order);
        payment.setGateway(paymentGateway);
        payment.setPaymentStatus("PENDING");
        order.setPayment(payment);
        order.setStatus("CONFIRMED");
        return saveOrderUseCase.call(order);
    }

    private PaymentGateway createPaymentGateway(String paymentMethod, Order order) {
        PaymentGateway paymentGateway = null;
        switch (paymentMethod) {
            case "momo": paymentGateway = new MoMoPaymentGateway(order); break;
            case "vnpay": paymentGateway = new VnPayPaymentGateway(order); break;
        }
        return paymentGateway;
    }
}
