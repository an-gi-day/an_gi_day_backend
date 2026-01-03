package com.bqtankiet.angiday.application.food.usecase;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GetFoodById {

    private final IFoodRepository foodRepository;

    @Autowired
    public GetFoodById(
            @Qualifier("FoodRepositoryImpl")
            IFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food call(Long foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }
}
