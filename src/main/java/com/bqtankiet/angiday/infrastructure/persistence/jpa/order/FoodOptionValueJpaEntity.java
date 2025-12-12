package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.*;

@Entity
@Table(name = "food_option_values")
public class FoodOptionValueJpaEntity {
    @Id
    private String id;

    private String optionValue;

    private int cost;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private FoodOptionJpaEntity option;
}
