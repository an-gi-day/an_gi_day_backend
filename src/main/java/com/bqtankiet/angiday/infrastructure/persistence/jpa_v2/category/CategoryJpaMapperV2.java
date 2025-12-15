package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base.JpaMapperV2;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface CategoryJpaMapperV2 extends JpaMapperV2<Category, CategoryJpaEntityV2> {
}
