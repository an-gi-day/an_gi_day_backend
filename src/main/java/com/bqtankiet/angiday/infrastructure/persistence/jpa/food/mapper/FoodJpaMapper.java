package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.mapper;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.brand.BrandJpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.category.CategoryJpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity.FoodJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {FoodOptionJpaMapper.class,
                FoodOptionValueJpaMapper.class,
                BrandJpaMapper.class,
                CategoryJpaMapper.class})
public interface FoodJpaMapper extends DomainEntityMapper<Food, FoodJpaEntity> {
}
