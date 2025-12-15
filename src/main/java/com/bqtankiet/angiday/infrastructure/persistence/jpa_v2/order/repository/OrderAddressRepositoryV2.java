package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderAddressV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderAddressRepositoryV2 extends JpaRepository<OrderAddressV2, Long> {
    Optional<OrderAddressV2> findByOrderId(Long orderId);
}