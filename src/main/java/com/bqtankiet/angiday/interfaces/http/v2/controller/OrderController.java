package com.bqtankiet.angiday.interfaces.http.v2.controller;


import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.OrderQueryService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderQueryService orderQueryService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(
            @PathVariable Long orderId
    ) {
        OrderResponse response = orderQueryService.getOrder(orderId);
        return ResponseEntity.ok(response);
    }
}
