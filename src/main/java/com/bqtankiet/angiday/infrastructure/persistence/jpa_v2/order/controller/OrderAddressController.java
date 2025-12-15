package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderAddressResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.OrderAddressQueryService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/address")
@RequiredArgsConstructor
public class OrderAddressController {

    private final OrderAddressQueryService addressQueryService;

    @GetMapping
    public ResponseEntity<OrderAddressResponse> getAddress(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(
                addressQueryService.getAddress(orderId)
        );
    }
}

