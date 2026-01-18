package com.bqtankiet.angiday.application.category.usecase;

import com.bqtankiet.angiday.application.base.InputUseCase;
import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.category.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCategoryById implements InputUseCase<Long, Category> {
    private final ICategoryRepository categoryRepository;

    @Override
    public Category call(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
