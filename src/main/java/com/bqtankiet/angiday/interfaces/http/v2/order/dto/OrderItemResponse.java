package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemResponse {
    private Long id;
    private OrderItemFood food;
    private OrderItemPricing itemPricing;
    private List<OrderItemOptionResponse> options;

    @Getter
    @Setter
    public static class OrderItemPricing {
        private int quantity;
        private long unitPrice;
        private long optionCost;
        private long subtotal;
    }

    @Getter
    @Setter
    public static class OrderItemFood {
        private Long id;
        private String name;
        private String imageUrl;
        private String description;
    }
}