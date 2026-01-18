package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.interfaces.http.v1.brand.BrandResponseDto;
import com.bqtankiet.angiday.interfaces.http.v1.category.CategoryResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author bqtankiet
 * @param id
 * @param name
 * @param description
 * @param imageUrl
 * @param brand
 * @param category
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FoodRespDto(
        Long id,
        String name,
        String description,
        String imageUrl,
        Double basePrice,
        BrandResponseDto brand,
        CategoryResponseDto category
) {
}
