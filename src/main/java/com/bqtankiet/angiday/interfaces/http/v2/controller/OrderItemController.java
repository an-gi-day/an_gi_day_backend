package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderItemsResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.OrderItemQueryService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders/{orderId}/items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemQueryService orderItemQueryService;

    @GetMapping
    public ResponseEntity<OrderItemsResponse> getItems(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(
                orderItemQueryService.getItems(orderId)
        );
    }
}

