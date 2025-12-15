package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface CategoryJpaMapper extends JpaMapper<Category, CategoryJpaEntity> {
}
