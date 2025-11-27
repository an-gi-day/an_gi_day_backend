package com.bqtankiet.angiday.interfaces.http.v1.category;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface CategoryResponseMapper extends JpaMapper<Category, CategoryResponseDto> {}