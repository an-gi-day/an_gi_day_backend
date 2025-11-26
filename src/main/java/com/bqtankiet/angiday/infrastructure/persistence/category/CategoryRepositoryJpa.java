package com.bqtankiet.angiday.infrastructure.persistence.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryJpa extends JpaRepository<CategoryEntity,Long> {
}
