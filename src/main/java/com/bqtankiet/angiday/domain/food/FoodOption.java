package com.bqtankiet.angiday.domain.food;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOption {
    private Long id;
    private String name;
    private List<FoodOptionValue> optionValues =  new ArrayList<>();
}
