package com.bqtankiet.angiday.application.food.usecase;

import com.bqtankiet.angiday.application.base.NoInputUseCase;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bqtankiet
 */
@Service
public class GetAllFood implements NoInputUseCase<List<Food>> {

    private final IFoodRepository foodRepository;

    @Autowired
    public GetAllFood(IFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> call() {
        var rs = foodRepository.findAll();
        return rs;
    }
}
