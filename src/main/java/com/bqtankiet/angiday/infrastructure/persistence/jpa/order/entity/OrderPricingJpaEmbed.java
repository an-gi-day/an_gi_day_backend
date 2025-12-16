package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class OrderPricingJpaEmbed {

    private int amount;

    private int shippingFee;

    private int discount;

    private int total;
}
