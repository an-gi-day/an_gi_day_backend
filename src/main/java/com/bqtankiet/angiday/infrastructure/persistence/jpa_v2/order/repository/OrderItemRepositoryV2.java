package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderItemV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepositoryV2 extends JpaRepository<OrderItemV2, Long> {
    List<OrderItemV2> findByOrderId(Long orderId);
}