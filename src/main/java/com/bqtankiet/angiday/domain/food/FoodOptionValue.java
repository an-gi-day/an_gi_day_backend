package com.bqtankiet.angiday.domain.food;

import lombok.Data;

@Data
public class FoodOptionValue {
    private String id;
    private String optionId;
    private String optionValue;
    private int cost;
}
