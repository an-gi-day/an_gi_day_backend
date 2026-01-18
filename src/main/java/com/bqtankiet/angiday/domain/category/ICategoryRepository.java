package com.bqtankiet.angiday.domain.category;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author bqtankiet
 */
public interface ICategoryRepository {

    List<Category> findAll();

    Optional<Category> findById(Long categoryId);
}
