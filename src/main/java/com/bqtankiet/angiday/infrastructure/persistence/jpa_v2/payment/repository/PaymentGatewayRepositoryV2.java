package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentGatewayJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGatewayRepositoryV2 extends JpaRepository<PaymentGatewayJpaEntityV2, Long> {
}