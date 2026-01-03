package com.bqtankiet.angiday.domain.payment.repository;

import com.bqtankiet.angiday.domain.payment.Payment;

import java.util.Optional;

public interface IPaymentRepository {

    Optional<Payment> findById(String id);
    Optional<Payment> createPayment(Payment payment);
    Optional<Payment> updatePayment(Payment payment);

}
