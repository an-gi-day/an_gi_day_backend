package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface FoodRespMapper extends DomainDtoMapper<Food, FoodRespDto> {
}
