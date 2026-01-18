package com.bqtankiet.angiday.application.order.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DraftOrderCommand {
    Long userId;
    List<OrderItem> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItem {
        Long foodId;
        Integer quantity;
        List<Long> optionIds;
    }

}