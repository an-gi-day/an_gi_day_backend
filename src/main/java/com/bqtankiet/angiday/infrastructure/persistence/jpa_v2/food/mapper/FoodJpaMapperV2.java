package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.mapper;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.category.CategoryJpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base.JpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.BrandJpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodJpaEntityV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses ={FoodOptionJpaMapperV2.class, BrandJpaMapperV2.class, CategoryJpaMapper.class})
public interface FoodJpaMapperV2 extends JpaMapperV2<Food, FoodJpaEntityV2> {
}
