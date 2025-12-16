package com.bqtankiet.angiday.domain.food;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOption {
    private Long id;
    private String name;
    private List<FoodOptionValue> optionValues =  new ArrayList<>();
}
