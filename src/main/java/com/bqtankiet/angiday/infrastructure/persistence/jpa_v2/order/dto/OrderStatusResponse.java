package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusResponse {
    private Long orderId;
    private OrderStatus status;
}