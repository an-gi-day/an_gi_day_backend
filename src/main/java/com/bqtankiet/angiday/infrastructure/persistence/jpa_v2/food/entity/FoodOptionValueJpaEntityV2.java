package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_option_values_v2")
@Getter
@Setter
public class FoodOptionValueJpaEntityV2 {
    @Id
    private String id;

    private String optionValue;

    private int cost;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private FoodOptionJpaEntityV2 option;
}
