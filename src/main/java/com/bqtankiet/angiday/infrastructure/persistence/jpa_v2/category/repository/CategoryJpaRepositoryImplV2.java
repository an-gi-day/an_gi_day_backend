package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.repository;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.category.ICategoryRepository;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.mapper.CategoryJpaMapperV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bqtankiet
 */
@Repository
public class CategoryJpaRepositoryImplV2 implements ICategoryRepository {
    private final CategoryJpaRepositoryV2 repositoryJpa;
    private final CategoryJpaMapperV2 mapper;

    @Autowired
    public CategoryJpaRepositoryImplV2(CategoryJpaRepositoryV2 repositoryJpa, CategoryJpaMapperV2 categoryMapper) {
        this.repositoryJpa = repositoryJpa;
        this.mapper = categoryMapper;
    }

    @Override
    public List<Category> findAll() {
        return repositoryJpa.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
