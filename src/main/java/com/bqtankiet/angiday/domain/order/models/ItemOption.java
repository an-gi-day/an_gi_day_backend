package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemOption {
    private String optionValue;
    private int cost;

    public static ItemOption createFromFoodOptionValue(FoodOptionValue foodOptionValue) {
        String optionValue = foodOptionValue.getOptionValue();
        int cost  = foodOptionValue.getCost();
        return new ItemOption(optionValue, cost);
    }
}
