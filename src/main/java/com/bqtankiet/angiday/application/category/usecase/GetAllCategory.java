package com.bqtankiet.angiday.application.category.usecase;

import com.bqtankiet.angiday.application.base.UseCase;
import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.domain.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCategory implements UseCase<GetAllCategory.Input, GetAllCategory.Output> {

    private final ICategoryRepository repository;

    @Autowired
    public GetAllCategory(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output call() {
        return new Output(repository.findAll());
    }

    @Override
    public GetAllCategory with(Input input) {
        return this;
    }

    public record Input() implements InputModel {}
    public record Output(List<Category> categories) implements OutputModel {}
}
