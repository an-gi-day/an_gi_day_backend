package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.FoodJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItemJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ nhiều OrderItem thuộc về 1 Order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderJpaEntity order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private FoodJpaEntity food;

    @Embedded
    private ItemPricingJpaEmbed itemPricing;

    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemOptionJpaEntity> options;
}
