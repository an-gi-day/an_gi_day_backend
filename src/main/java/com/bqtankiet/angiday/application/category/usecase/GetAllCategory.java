package com.bqtankiet.angiday.application.category.usecase;

import com.bqtankiet.angiday.application.base.NoInputUseCase;
import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bqtankiet
 */
@Service
public class GetAllCategory implements NoInputUseCase<List<Category>> {

    private final ICategoryRepository repository;

    @Autowired
    public GetAllCategory(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> call() {
        return repository.findAll();
    }
}
