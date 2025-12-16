package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderPaymentResponse;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/payment")
@RequiredArgsConstructor
public class GetOrderPaymentController {


    @GetMapping
    public ResponseEntity<OrderPaymentResponse> getPayment(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(null);
    }
}

