package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long id;
    private Food food;
    private OrderItemPricing itemPricing;
    private List<OrderItemOption> options;

    public static OrderItem create(Food food, Integer quantity, List<FoodOptionValue> selectedOptions) {
        OrderItemPricing itemPricing = OrderItemPricing.autoPricing(food, quantity, selectedOptions);
        List<OrderItemOption> itemOptions = selectedOptions.stream().map(OrderItemOption::createFromFoodOptionValue).toList();
        return new OrderItem(null, food, itemPricing, itemOptions);
    }
}
