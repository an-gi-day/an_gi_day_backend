package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderAddressResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.OrderAddressQueryService;
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

