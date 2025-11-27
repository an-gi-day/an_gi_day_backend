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
 * @param soldCount
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FoodRespDto(
        String id,
        String name,
        String description,
        String imageUrl,
        BrandResponseDto brand,
        CategoryResponseDto category,
        Integer soldCount
) {
}
