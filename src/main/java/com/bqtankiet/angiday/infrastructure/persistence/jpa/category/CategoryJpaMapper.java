package com.bqtankiet.angiday.infrastructure.persistence.jpa.category;

import com.bqtankiet.angiday.domain.category.model.Category;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryJpaMapper extends JpaMapper<Category, CategoryJpaEntity> {
}
