package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.entity.BrandJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bqtankiet
 */
public interface BrandJpaRepositoryV2 extends JpaRepository<BrandJpaEntityV2,Long> {
}
