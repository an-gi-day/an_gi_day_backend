package com.bqtankiet.angiday.domain.order.models;

import lombok.Data;

@Data
public class OrderPricing {
    private int amount;
    private int shipping;
    private int discount;
    private int total;

    public void updatePricing(OrderItem orderItem) {
        int subtotal = orderItem.getItemPricing().getSubtotal();
        this.amount += subtotal;
        this.total += subtotal;
    }
}
