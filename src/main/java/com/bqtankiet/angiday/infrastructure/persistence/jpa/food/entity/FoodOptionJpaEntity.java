package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food_options")
public class FoodOptionJpaEntity {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodOptionValueJpaEntity> optionValues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodJpaEntity food;

    //TODO: có thể thêm loại option (select, multi-select, input,...)
}

