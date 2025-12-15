package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemResponse {
    private Long id;
    private Long foodId;
    private String name;
    private String imageUrl;
    private String description;
    private int quantity;
    private long unitPrice;
    private long optionCost;
    private long subtotal;
    private List<OrderItemOptionResponse> options;
}