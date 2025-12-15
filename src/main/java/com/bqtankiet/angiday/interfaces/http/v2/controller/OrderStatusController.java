package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderStatusResponse;
import com.bqtankiet.angiday.interfaces.http.v2.dto.UpdateOrderStatusRequest;
import com.bqtankiet.angiday.interfaces.http.v2.service.OrderCommandService;
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

