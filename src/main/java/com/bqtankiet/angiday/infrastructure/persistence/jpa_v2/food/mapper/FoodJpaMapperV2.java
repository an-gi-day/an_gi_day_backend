package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.mapper;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base.JpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodJpaEntity;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface FoodJpaMapper extends JpaMapper<Food, FoodJpaEntity> {
}
