package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_items_v2")
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private Long foodId;
    private String name;
    private String imageUrl;

    @Column(length = 500)
    private String description;

    private int quantity;
    private long unitPrice;
    private long optionCost;
    private long subtotal;

    @OneToMany(
            mappedBy = "orderItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItemOption> options = new ArrayList<>();
}

