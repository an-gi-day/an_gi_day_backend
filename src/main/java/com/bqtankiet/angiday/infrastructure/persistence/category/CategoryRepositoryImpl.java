package com.bqtankiet.angiday.infrastructure.persistence.category;

import com.bqtankiet.angiday.domain.category.model.Category;
import com.bqtankiet.angiday.domain.category.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    private final CategoryRepositoryJpa repositoryJpa;
    private final CategoryEntityMapper mapper;

    @Autowired
    public CategoryRepositoryImpl(CategoryRepositoryJpa repositoryJpa, CategoryEntityMapper categoryMapper) {
        this.repositoryJpa = repositoryJpa;
        this.mapper = categoryMapper;
    }

    @Override
    public List<Category> findAll() {
        return repositoryJpa.findAll()
                .stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());
    }
}
