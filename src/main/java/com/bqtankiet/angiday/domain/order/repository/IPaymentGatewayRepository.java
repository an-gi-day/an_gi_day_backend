package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.PaymentGateway;

import java.util.Optional;

public interface IPaymentGatewayRepository {

    Optional<PaymentGateway> findById(String id);
    Optional<PaymentGateway> createPaymentGateway(PaymentGateway gateway);
    Optional<PaymentGateway> updatePaymentGateway(PaymentGateway gateway);

}
