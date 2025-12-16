package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderVouchersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/vouchers")
@RequiredArgsConstructor
public class GetOrderVoucherController {


    @GetMapping
    public ResponseEntity<OrderVouchersResponse> getAppliedVouchers(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(null);
    }
}

