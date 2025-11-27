package com.bqtankiet.angiday.application.food.usecase;

import com.bqtankiet.angiday.application.base.UseCase;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bqtankiet
 */
@Service
public class GetAllFood implements UseCase<GetAllFood.Input, GetAllFood.Output> {

    private final IFoodRepository foodRepository;

    @Autowired
    public GetAllFood(IFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Output call() {
        var rs = foodRepository.findAll();
        return new Output(rs);
    }

    @Override
    public GetAllFood with(Input input) {
        return this;
    }

    public record Input() implements InputModel {}
    public record Output(List<Food> foods) implements OutputModel {}
}
