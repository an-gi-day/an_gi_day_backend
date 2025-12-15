package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemOptionRepository extends JpaRepository<OrderItemOption, Long> {
    List<OrderItemOption> findByOrderItemId(Long orderItemId);
}