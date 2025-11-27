package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface FoodRespMapper extends JpaMapper<Food, FoodRespDto> {
}
