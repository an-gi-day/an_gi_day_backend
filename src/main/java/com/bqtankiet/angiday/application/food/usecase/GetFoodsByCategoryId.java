package com.bqtankiet.angiday.application.food.usecase;

import com.bqtankiet.angiday.application.base.InputUseCase;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFoodsByCategoryId implements InputUseCase<Long, List<Food>> {

    private final IFoodRepository foodRepository;

    @Override
    public List<Food> call(Long input) {
        return foodRepository.findAllByCategoryId(input);
    }
}
