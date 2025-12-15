package com.bqtankiet.angiday.interfaces.http.v1.checkout.dto;

import java.util.List;

public record OrderItemRequest(
        String foodId,
        Integer quantity,
        List<String> optionIds
){}
