package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderPricingV2 {

    private long subtotal;
    private long shipping;
    private long discount;
    private long total;

    @Column(length = 3)
    private String currency;
}
