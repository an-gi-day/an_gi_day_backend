package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.food.Food;

import java.util.List;
import java.util.Objects;

public class OrderItem {
    private Food food;
    private ItemPricing itemPricing;
    private List<ItemOption> options;

    public OrderItem() {
    }

    public OrderItem(Food food, ItemPricing itemPricing, List<ItemOption> options) {
        this.food = food;
        this.itemPricing = itemPricing;
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItem item)) return false;
        return Objects.equals(food, item.food)
                && Objects.equals(itemPricing, item.itemPricing)
                && Objects.equals(options, item.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, itemPricing, options);
    }

    // getters & setters

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public ItemPricing getItemPricing() {
        return itemPricing;
    }

    public void setItemPricing(ItemPricing itemPricing) {
        this.itemPricing = itemPricing;
    }

    public List<ItemOption> getOptions() {
        return options;
    }

    public void setOptions(List<ItemOption> options) {
        this.options = options;
    }
}
