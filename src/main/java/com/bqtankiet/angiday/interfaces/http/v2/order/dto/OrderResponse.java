package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import com.bqtankiet.angiday.domain.order.models.OrderPricing;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private String status;
    private OrderPricing pricing;
    private Instant createdAt;
    private Instant updatedAt;
}