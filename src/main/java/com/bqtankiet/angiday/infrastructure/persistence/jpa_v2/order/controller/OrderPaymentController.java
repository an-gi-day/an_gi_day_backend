package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderPaymentResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.OrderPaymentQueryService;
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

