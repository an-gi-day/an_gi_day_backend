package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.mapper;

import com.bqtankiet.angiday.domain.food.FoodOption;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity.FoodOptionJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {FoodOptionValueJpaMapper.class}
)
public interface FoodOptionJpaMapper extends
        DomainEntityMapper<FoodOption, FoodOptionJpaEntity> {}
