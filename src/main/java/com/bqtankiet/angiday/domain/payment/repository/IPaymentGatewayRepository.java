package com.bqtankiet.angiday.domain.payment.repository;

import com.bqtankiet.angiday.domain.payment.PaymentGateway;

import java.util.Optional;

public interface IPaymentGatewayRepository {

    Optional<PaymentGateway> findById(String id);
    Optional<PaymentGateway> createPaymentGateway(PaymentGateway gateway);
    Optional<PaymentGateway> updatePaymentGateway(PaymentGateway gateway);

}
