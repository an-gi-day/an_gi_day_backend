package com.bqtankiet.angiday.interfaces.http.v1.order.dto;

import java.util.List;

public record OrderItemRequest(
        String foodId,
        Integer quantity,
        List<String> optionIds
){}
