package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderItemsResponse;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders/{orderId}/items")
@RequiredArgsConstructor
public class GetOrderItemController {


    @GetMapping
    public ResponseEntity<OrderItemsResponse> getItems(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(null);
    }
}

