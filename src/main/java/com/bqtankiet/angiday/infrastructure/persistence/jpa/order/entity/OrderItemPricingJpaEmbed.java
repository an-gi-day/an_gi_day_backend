package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderItemPricingJpaEmbed {

    private int amount;

    private int optionCost;

    private int quantity;

    private int subtotal;
}
