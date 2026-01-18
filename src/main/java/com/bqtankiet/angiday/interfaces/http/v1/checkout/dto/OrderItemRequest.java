package com.bqtankiet.angiday.interfaces.http.v1.checkout.dto;

import java.util.List;

public record OrderItemRequest(
        Long foodId,
        Integer quantity,
        List<Long> optionIds
){}
