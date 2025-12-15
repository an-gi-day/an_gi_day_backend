package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderStatusResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.UpdateOrderStatusRequest;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/status")
@RequiredArgsConstructor
public class OrderStatusController {

    private final OrderCommandService orderCommandService;

    @PatchMapping
    public ResponseEntity<OrderStatusResponse> updateStatus(
            @PathVariable Long orderId,
            @RequestBody UpdateOrderStatusRequest request
    ) {
        return ResponseEntity.ok(
                orderCommandService.updateStatus(orderId, request)
        );
    }
}

