package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import lombok.*;

import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemPricing {
    private int amount;
    private int optionCost;
    private int quantity;
    private int subtotal;

    public static OrderItemPricing autoPricing(Food food, int quantity, List<FoodOptionValue> selectedOptions) {
        int basePrice = food.getBasePrice().intValue();
        int optionCost = selectedOptions.stream().mapToInt(FoodOptionValue::getCost).sum();
        int subtotal = (basePrice+optionCost) * quantity;
        return new OrderItemPricing(basePrice, optionCost, quantity, subtotal);
    }
}
