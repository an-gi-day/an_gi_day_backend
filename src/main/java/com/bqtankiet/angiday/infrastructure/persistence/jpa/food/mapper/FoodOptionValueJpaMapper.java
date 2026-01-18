package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.mapper;

import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity.FoodOptionValueJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodOptionValueJpaMapper extends
        DomainEntityMapper<FoodOptionValue, FoodOptionValueJpaEntity> {
}
