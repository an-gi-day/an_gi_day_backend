package com.bqtankiet.angiday.infrastructure.persistence.jpa.food;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {

    private final FoodJpaRepository foodJpaRepository;
    private final FoodJpaMapper foodJpaMapper;

    @Autowired
    public FoodRepositoryImpl(FoodJpaRepository foodJpaRepository, FoodJpaMapper foodJpaMapper) {
        this.foodJpaRepository = foodJpaRepository;
        this.foodJpaMapper = foodJpaMapper;
    }

    @Override
    public Optional<Food> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Food> findAll() {
        var rs = foodJpaRepository.findAll();
        return rs.stream()
                .map(foodJpaMapper::dtoToModel)
                .toList();
    }

    @Override
    public List<Food> findAllByCategoryId(String categoryId) {
        return List.of();
    }
}
