package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_options")
@Getter
@Setter
public class ItemOptionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_option_id")
    private FoodOptionJpaEntity foodOption;

    @ManyToOne()
    @JoinColumn(name = "order_item_id")
    private OrderItemJpaEntity orderItem;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String option_value;

    private int cost;

    private boolean snapshot;
}
