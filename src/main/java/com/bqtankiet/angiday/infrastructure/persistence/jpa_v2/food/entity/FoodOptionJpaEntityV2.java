package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food_options_v2")
public class FoodOptionJpaEntityV2 {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodOptionValueJpaEntityV2> optionValues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodJpaEntityV2 food;

    //TODO: có thể thêm loại option (select, multi-select, input,...)
}

