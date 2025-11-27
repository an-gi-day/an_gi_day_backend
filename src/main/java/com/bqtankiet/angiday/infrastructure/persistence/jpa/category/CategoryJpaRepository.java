package com.bqtankiet.angiday.infrastructure.persistence.jpa.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bqtankiet
 */
@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity,Long> {
}
