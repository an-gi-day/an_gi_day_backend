package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.entity.CategoryJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bqtankiet
 */
@Repository
public interface CategoryJpaRepositoryV2 extends JpaRepository<CategoryJpaEntityV2,Long> {
}
