package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepositoryV2 extends JpaRepository<PaymentJpaEntityV2, Long> {
    Optional<PaymentJpaEntityV2> findByOrderId(Long orderId);
}