package com.bqtankiet.angiday.application.temp;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayService {

    PaymentGatewayService() {
    }

    public PaymentGateway create(String paymentMethod, Order order) {
        if("momo".equalsIgnoreCase(paymentMethod)) {
            return createMoMoGateway(order);
        }
        return null;
    }

    public PaymentGateway createMoMoGateway(Order order) {
        // TODO: Example
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setName("MoMo");
        paymentGateway.setAppUrl("momo://app?action=payWithApp&isScanQR=false&serviceType=app&sid=TU9NT0JLVU4yMDE4MDUyOXxPRDE3NjU3ODc2NTM4MzQ&v=3.0");
        paymentGateway.setWebUrl("https://test-payment.momo.vn/v2/gateway/pay?t=TU9NT0JLVU4yMDE4MDUyOXxPRDE3NjU3ODc2NTM4MzQ&s=a9131a0bfaa64d0ce22cbd3de5a3302bae10f4e39c241d7dfd59ecd160df98db");
        return paymentGateway;
    }

}
