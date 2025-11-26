package com.bqtankiet.angiday.interfaces.http.v1.category;

import com.bqtankiet.angiday.domain.category.model.Category;
import com.bqtankiet.angiday.interfaces.http.base.DataMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements DataMapper<Category, CategoryResponseDto> {
    @Override
    public CategoryResponseDto modelToDto(Category model) {
        return new CategoryResponseDto(
                model.getId(),
                model.getName(),
                model.getImageUrl()
        );
    }

    @Override
    public Category dtoToModel(CategoryResponseDto dto) {
        Category category = new Category();
        category.setId(dto.id());
        category.setName(dto.name());
        category.setImageUrl(dto.imageUrl());
        return category;
    }
}
