package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderJpaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM OrderJpaEntity o WHERE o.userId = :userId AND o.status = :status")
    void deleteByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
}
