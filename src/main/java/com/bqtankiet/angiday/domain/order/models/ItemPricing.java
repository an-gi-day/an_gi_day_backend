package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ItemPricing {
    private int amount;
    private int optionCost;
    private int quantity;
    private int subtotal;

    public static ItemPricing autoPricing(Food food, int quantity, List<FoodOptionValue> selectedOptions) {
        int basePrice = food.getBasePrice().intValue();
        int optionCost = selectedOptions.stream().mapToInt(FoodOptionValue::getCost).sum();
        int subtotal = (basePrice+optionCost) * quantity;
        return new ItemPricing(basePrice, optionCost, quantity, subtotal);
    }
}
