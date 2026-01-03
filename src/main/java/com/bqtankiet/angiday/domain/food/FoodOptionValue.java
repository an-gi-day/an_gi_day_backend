package com.bqtankiet.angiday.domain.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOptionValue {
    private Long id;
    private String optionValue;
    private int cost;
}
