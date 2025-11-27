package com.bqtankiet.angiday.domain.food;

import java.util.List;
import java.util.Optional;

public interface IFoodRepository {

    Optional<Food> findById(String id);

    List<Food> findAll();

    List<Food> findAllByCategoryId(String categoryId);

}
