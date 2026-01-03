package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemOption {
    private Long id;
    private String optionValue;
    private int cost;

    public OrderItemOption(String optionValue, int cost) {
        this.optionValue = optionValue;
        this.cost = cost;
    }

    public static OrderItemOption createFromFoodOptionValue(FoodOptionValue foodOptionValue) {
        String optionValue = foodOptionValue.getOptionValue();
        int cost  = foodOptionValue.getCost();
        return new OrderItemOption(null, optionValue, cost);
    }

}
