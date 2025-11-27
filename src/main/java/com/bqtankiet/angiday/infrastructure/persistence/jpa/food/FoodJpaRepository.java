package com.bqtankiet.angiday.infrastructure.persistence.jpa.food;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bqtankiet
 */
public interface FoodJpaRepository extends JpaRepository<FoodJpaEntity,Long> {
}
