package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderAddressResponse;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/address")
@RequiredArgsConstructor
public class GetOrderAddressController {


    @GetMapping
    public ResponseEntity<OrderAddressResponse> getAddress(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(null);
    }
}

