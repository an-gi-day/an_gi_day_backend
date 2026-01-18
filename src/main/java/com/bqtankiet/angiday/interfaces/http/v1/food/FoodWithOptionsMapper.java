package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.category.CategoryJpaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    uses = {CategoryJpaMapper.class}
)
public abstract class FoodWithOptionsMapper
        implements DomainDtoMapper<Food, FoodWithOptionsDto> {
}
