package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_item_options_v2")
@Getter @Setter
public class OrderItemOptionV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id")
    private OrderItemV2 orderItem;

    private String optionValue;

    private long cost;
}
