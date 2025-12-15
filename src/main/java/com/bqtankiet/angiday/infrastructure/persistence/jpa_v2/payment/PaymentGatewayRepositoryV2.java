package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGatewayRepositoryV2 extends JpaRepository<PaymentGatewayV2, Long> {
}