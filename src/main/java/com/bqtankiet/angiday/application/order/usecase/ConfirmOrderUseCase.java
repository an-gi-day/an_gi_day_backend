package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.application.payment.CreateMoMoGateway;
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
    private final CreateMoMoGateway createMoMoGateway;

    public Order execute(Order order) {
        if (!order.isValid()) {
            return order;
        }
        order.setCode(System.currentTimeMillis()+""+order.getId());
        order.setStatus("CONFIRMED");

        Payment payment = order.getPayment();
        PaymentGateway paymentGateway = createPaymentGateway(payment.getPaymentMethod(), order);
        payment.setPaymentStatus("PENDING");
        payment.setGateway(paymentGateway);
        order.setPayment(payment);

        return saveOrderUseCase.call(order);
    }

    private PaymentGateway createPaymentGateway(String paymentMethod, Order order) {
        PaymentGateway paymentGateway = null;
        switch (paymentMethod) {
            case "momo": paymentGateway = createMoMoGateway.execute(order); break;
            case "vnpay": paymentGateway = new VnPayPaymentGateway(order); break;
        }
        return paymentGateway;
    }
}
