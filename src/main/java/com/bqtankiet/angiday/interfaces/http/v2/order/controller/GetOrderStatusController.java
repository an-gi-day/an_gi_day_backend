package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderStatusResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.UpdateOrderStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/status")
@RequiredArgsConstructor
public class GetOrderStatusController {


    @PatchMapping
    public ResponseEntity<OrderStatusResponse> updateStatus(
            @PathVariable Long orderId,
            @RequestBody UpdateOrderStatusRequest request
    ) {
        return ResponseEntity.ok(null);
    }
}

