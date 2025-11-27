package com.bqtankiet.angiday.infrastructure.persistence.jpa.category;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    private final CategoryJpaRepository repositoryJpa;
    private final CategoryJpaMapper mapper;

    @Autowired
    public CategoryRepositoryImpl(CategoryJpaRepository repositoryJpa, CategoryJpaMapper categoryMapper) {
        this.repositoryJpa = repositoryJpa;
        this.mapper = categoryMapper;
    }

    @Override
    public List<Category> findAll() {
        return repositoryJpa.findAll()
                .stream()
                .map(mapper::dtoToModel)
                .collect(Collectors.toList());
    }
}
