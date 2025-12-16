package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.mapper;

import com.bqtankiet.angiday.domain.food.FoodOption;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.JpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodOptionJpaEntityV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {
            FoodOptionValueMapperV2.class,
        }
)
public interface FoodOptionJpaMapperV2 extends JpaMapperV2<FoodOption, FoodOptionJpaEntityV2> {}
