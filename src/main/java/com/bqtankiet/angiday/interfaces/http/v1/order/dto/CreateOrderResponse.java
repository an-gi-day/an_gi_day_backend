package com.bqtankiet.angiday.interfaces.http.v1.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateOrderResponse(
        String orderId,
        List<OrderItemResponse> items,
        JsonNode orderPricing,
        JsonNode payment,
        JsonNode address,
        String voucherCode,
        String status,
        Instant createdAt
) {
    public record OrderItemResponse(
            FoodResponse food,
            JsonNode itemPricing,
            JsonNode options
    ) {
    }
    public record FoodResponse(
            String id,
            String name,
            String imageUrl,
            String description
    ){
    }
}
