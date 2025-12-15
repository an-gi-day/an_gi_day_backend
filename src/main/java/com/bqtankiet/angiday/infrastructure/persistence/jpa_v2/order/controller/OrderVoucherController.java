package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderVouchersResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.OrderVoucherQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/vouchers")
@RequiredArgsConstructor
public class OrderVoucherController {

    private final OrderVoucherQueryService voucherQueryService;

    @GetMapping
    public ResponseEntity<OrderVouchersResponse> getAppliedVouchers(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(
                voucherQueryService.getAppliedVouchers(orderId)
        );
    }
}

