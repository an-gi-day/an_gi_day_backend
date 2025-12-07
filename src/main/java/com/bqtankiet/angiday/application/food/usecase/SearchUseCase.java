package com.bqtankiet.angiday.application.food.usecase;

import com.bqtankiet.angiday.application.base.InputUseCase;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUseCase implements InputUseCase<String, List<Food>> {
    private final IFoodRepository foodRepository;

    public SearchUseCase(IFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    @Override
    public List<Food> call(String keyword) {
        return foodRepository.searchByKeyword(keyword);
    }
}
