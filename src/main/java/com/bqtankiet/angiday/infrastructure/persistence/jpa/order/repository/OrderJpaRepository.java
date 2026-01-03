package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.repository;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderJpaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity,Long> {
    @Modifying
    void deleteByUserIdAndStatus(Long userId, String status);

    Optional<Order> findByCode(String code);
}
