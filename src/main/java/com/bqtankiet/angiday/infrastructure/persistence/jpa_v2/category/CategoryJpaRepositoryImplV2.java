package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category;

import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.category.ICategoryRepository;
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
                .map(mapper::dtoToModel)
                .collect(Collectors.toList());
    }
}
