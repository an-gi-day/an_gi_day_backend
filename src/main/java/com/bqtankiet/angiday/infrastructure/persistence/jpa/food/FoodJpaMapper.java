package com.bqtankiet.angiday.infrastructure.persistence.jpa.food;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface FoodJpaMapper extends JpaMapper<Food, FoodJpaEntity> {
}
