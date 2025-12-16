package com.bqtankiet.angiday.infrastructure.persistence.jpa.category;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface CategoryJpaMapper extends DomainEntityMapper<Category, CategoryJpaEntity> {
}
