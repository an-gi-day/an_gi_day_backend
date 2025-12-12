package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.Payment;

import java.util.Optional;

public interface IPaymentRepository {

    Optional<Payment> findById(String id);
    Optional<Payment> createPayment(Payment payment);
    Optional<Payment> updatePayment(Payment payment);

}
