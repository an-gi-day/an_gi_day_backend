package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import java.util.List;

public record CreateDraftOrderRequest(
        List<OrderItem> items,
        Long addressId,
        String paymentMethod
) {
    public record OrderItem(
           Long foodId,
           List<Long> optionIds
    ){}
}
