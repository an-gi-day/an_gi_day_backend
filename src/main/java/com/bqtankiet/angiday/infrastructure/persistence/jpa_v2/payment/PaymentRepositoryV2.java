package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepositoryV2 extends JpaRepository<PaymentV2, Long> {
    Optional<PaymentV2> findByOrderId(Long orderId);
}