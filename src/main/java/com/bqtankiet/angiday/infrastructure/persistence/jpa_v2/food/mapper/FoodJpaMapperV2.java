package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.mapper;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base.JpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodJpaEntityV2;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface FoodJpaMapperV2 extends JpaMapperV2<Food, FoodJpaEntityV2> {
}
