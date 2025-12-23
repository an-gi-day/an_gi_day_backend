package com.bqtankiet.angiday.infrastructure.payment.momo;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;
import com.bqtankiet.angiday.domain.payment.PaymentGatewayProvider;
import com.bqtankiet.angiday.infrastructure.payment.momo.mservice.config.Environment;
import com.bqtankiet.angiday.infrastructure.payment.momo.mservice.enums.RequestType;
import com.bqtankiet.angiday.infrastructure.payment.momo.mservice.models.PaymentResponse;
import com.bqtankiet.angiday.infrastructure.payment.momo.mservice.processor.CreateOrderMoMo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;

@Service
@Slf4j
public class MoMoPaymentProvider implements PaymentGatewayProvider {

    @Override
    public PaymentGateway getPaymentGateway(Order order) {
        // TODO: send request to momo api
        PaymentResponse paymentResponse = createOrderMoMo(order);
        if (paymentResponse.getResultCode() == 41) {
            return order.getPayment().getGateway();
        }
        PaymentGateway gateway = new PaymentGateway();
        gateway.setName("momo");
        gateway.setWebUrl(paymentResponse.getPayUrl());
        gateway.setAppUrl(paymentResponse.getDeeplink());
        return gateway;
    }

    private PaymentResponse createOrderMoMo(Order order) {
        try {
            InputStream input = Environment.class.getClassLoader().getResourceAsStream("momo.properties");
            Properties prop = new Properties();
            prop.load(input);

            String requestId = String.valueOf(System.currentTimeMillis());
            String orderId = String.valueOf(order.getCode());
//            long amount = order.getOrderPricing().getTotal();
            long amount = 1000; // test

            String orderInfo = "Thanh toán đơn hàng AnGiDay";
            String extraData = "";
            String bankCode = "SML";
            String customerNumber = "0963181714";
            String returnURL = "angiday:/home";
            String notifyURL = prop.getProperty("DEV_IPN_URL");

            Environment environment = Environment.selectEnv(Environment.EnvTarget.DEV);

            PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(
                    environment,
                    orderId,
                    requestId,
                    Long.toString(amount),
                    orderInfo,
                    returnURL,
                    notifyURL,
                    extraData,
                    RequestType.CAPTURE_WALLET,
                    Boolean.TRUE);
            return  captureWalletMoMoResponse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
