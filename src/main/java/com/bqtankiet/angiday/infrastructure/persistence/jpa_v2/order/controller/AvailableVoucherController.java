package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository.AvailableVoucherResponseV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.VoucherQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vouchers")
@RequiredArgsConstructor
public class AvailableVoucherController {

    private final VoucherQueryService voucherQueryService;

    @GetMapping("/available")
    public ResponseEntity<AvailableVoucherResponseV2> getAvailable(
            @RequestParam Long orderId
    ) {
        return ResponseEntity.ok(
                voucherQueryService.getAvailable(orderId)
        );
    }
}

