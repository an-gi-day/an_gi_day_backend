package com.bqtankiet.angiday.domain.order.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
