package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.mapper;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.JpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.entity.CategoryJpaEntityV2;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface CategoryJpaMapperV2 extends JpaMapperV2<Category, CategoryJpaEntityV2> {
}
