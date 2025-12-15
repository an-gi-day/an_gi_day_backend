package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemsResponse {
    private List<OrderItemsResponse> items;
}