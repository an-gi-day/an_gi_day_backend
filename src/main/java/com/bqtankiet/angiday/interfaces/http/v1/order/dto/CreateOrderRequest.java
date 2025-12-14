package com.bqtankiet.angiday.interfaces.http.v1.order.dto;

import java.util.List;

public record CreateOrderRequest(
        List<OrderItemRequest> items,
        String addressId,
        String voucherCode,
        String paymentMethod
) {

}



