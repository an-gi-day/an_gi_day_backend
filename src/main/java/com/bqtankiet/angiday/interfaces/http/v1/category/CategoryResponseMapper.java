package com.bqtankiet.angiday.interfaces.http.v1.category;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface CategoryResponseMapper
        extends DomainDtoMapper<Category, CategoryResponseDto> {}