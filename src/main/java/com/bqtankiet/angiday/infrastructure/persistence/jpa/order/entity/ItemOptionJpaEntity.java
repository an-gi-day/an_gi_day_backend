package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item_options")
public class ItemOptionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "order_item_id")
    private OrderItemJpaEntity orderItem;

    @Column(length = 100)
    private String optionValue;

    private int cost;

}
