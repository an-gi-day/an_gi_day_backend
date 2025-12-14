package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_option_values")
@Getter
@Setter
public class FoodOptionValueJpaEntity {
    @Id
    private String id;

    private String optionValue;

    private int cost;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private FoodOptionJpaEntity option;
}
