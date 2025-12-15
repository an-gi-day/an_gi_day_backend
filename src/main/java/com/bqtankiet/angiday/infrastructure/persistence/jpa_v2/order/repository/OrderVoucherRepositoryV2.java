package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderVoucherV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderVoucherRepositoryV2 extends JpaRepository<OrderVoucherV2, Long> {
    List<OrderVoucherV2> findByOrderId(Long orderId);
}