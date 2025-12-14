package com.bqtankiet.angiday.domain.food;

import lombok.Data;

import java.util.List;

@Data
public class FoodOption {
    private String id;
    private String name;
    private List<FoodOptionValue> optionValues;
}
