package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.domain.food.FoodOption;
import com.bqtankiet.angiday.interfaces.http.v1.brand.BrandResponseDto;
import com.bqtankiet.angiday.interfaces.http.v1.category.CategoryResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FoodWithOptionsDto(
        String id,
        String name,
        String description,
        String imageUrl,
        Double basePrice,
        BrandResponseDto brand,
        CategoryResponseDto category,
        List<FoodOption> options
) {
}
