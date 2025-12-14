package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import com.bqtankiet.angiday.domain.food.IFoodRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderItem {
    private String id;
    private Food food;
    private ItemPricing itemPricing;
    private List<ItemOption> options;

    public static OrderItem create(Food food, Integer quantity, List<FoodOptionValue> selectedOptions) {
        ItemPricing itemPricing = ItemPricing.autoPricing(food, quantity, selectedOptions);
        List<ItemOption> itemOptions = selectedOptions.stream().map(ItemOption::createFromFoodOptionValue).toList();
        return new OrderItem(null, food, itemPricing, itemOptions);
    }
}
