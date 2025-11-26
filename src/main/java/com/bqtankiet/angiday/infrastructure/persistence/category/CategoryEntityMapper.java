package com.bqtankiet.angiday.infrastructure.persistence.category;

import com.bqtankiet.angiday.domain.category.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityMapper {

    public Category entityToModel(CategoryEntity entity) {
        Category category = new Category();
        category.setId(String.valueOf(entity.getId()));
        category.setName(entity.getName());
        category.setImageUrl(entity.getImageUrl());
        return category;
    }

}
