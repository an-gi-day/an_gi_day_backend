package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.FoodJpaEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "food_options")
public class FoodOptionJpaEntity {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodOptionValueJpaEntity> optionValues;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodJpaEntity food;

    //TODO: có thể thêm loại option (select, multi-select, input,...)
}

