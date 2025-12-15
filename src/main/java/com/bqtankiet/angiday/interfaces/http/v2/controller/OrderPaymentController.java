package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderPaymentResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.OrderPaymentQueryService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/payment")
@RequiredArgsConstructor
public class OrderPaymentController {

    private final OrderPaymentQueryService paymentQueryService;

    @GetMapping
    public ResponseEntity<OrderPaymentResponse> getPayment(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(
                paymentQueryService.getPayment(orderId)
        );
    }
}

