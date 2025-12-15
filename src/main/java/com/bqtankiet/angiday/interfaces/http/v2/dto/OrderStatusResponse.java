package com.bqtankiet.angiday.interfaces.http.v2.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderStatusV2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusResponse {
    private Long orderId;
    private OrderStatusV2 status;
}