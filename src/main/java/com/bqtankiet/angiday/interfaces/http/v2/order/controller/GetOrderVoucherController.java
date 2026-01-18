package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderVouchersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GetOrderVoucherController.URL)
@RequiredArgsConstructor
public class GetOrderVoucherController {
    public static final String URL = "/api/v2/orders/{orderId}/vouchers";

    @GetMapping
    public ResponseEntity<OrderVouchersResponse> getAppliedVouchers(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}

