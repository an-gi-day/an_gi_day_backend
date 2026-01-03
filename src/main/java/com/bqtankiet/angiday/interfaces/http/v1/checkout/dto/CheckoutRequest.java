package com.bqtankiet.angiday.interfaces.http.v1.checkout.dto;

import java.util.List;

public record CheckoutRequest(
        List<OrderItemRequest> items,
        String addressId,
        String voucherCode,
        String paymentMethod
) {

}



