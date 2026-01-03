package com.bqtankiet.angiday.domain.food;

import java.util.List;
import java.util.Optional;

/**
 * @author bqtankiet
 */
public interface IFoodRepository {

    Optional<Food> findById(Long id);

    List<Food> findAll();

    List<Food> findAllByCategoryId(Long categoryId);

    //    phong
    List<Food> searchByKeyword(String keyword);
}
