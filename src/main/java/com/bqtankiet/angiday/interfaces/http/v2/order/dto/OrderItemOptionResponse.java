package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemOptionResponse {
    private Long id;
    private String optionValue;
    private long cost;
}