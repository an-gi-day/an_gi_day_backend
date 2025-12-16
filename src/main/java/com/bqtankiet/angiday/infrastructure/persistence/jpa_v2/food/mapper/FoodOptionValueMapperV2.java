package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.mapper;

import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.JpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodOptionValueJpaEntityV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodOptionValueMapperV2 extends JpaMapperV2<FoodOptionValue, FoodOptionValueJpaEntityV2> {}
