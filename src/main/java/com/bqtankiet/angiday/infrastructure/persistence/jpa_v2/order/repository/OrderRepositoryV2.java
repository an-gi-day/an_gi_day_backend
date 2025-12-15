package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryV2 extends JpaRepository<OrderV2, Long> {
}