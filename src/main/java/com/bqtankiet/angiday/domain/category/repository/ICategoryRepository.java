package com.bqtankiet.angiday.domain.category.repository;

import com.bqtankiet.angiday.domain.category.model.Category;

import java.util.List;

public interface ICategoryRepository {

    List<Category> findAll();

}
