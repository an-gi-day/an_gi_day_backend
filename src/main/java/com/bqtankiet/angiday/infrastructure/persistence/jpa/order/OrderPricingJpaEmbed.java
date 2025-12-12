package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderPricingJpaEmbed {

    private int amount;

    private int shippingFee;

    private int discount;

    private int total;
}
