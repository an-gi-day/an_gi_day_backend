package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository.AvailableVoucherResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.VoucherQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vouchers")
@RequiredArgsConstructor
public class AvailableVoucherController {

    private final VoucherQueryService voucherQueryService;

    @GetMapping("/available")
    public ResponseEntity<AvailableVoucherResponse> getAvailable(
            @RequestParam Long orderId
    ) {
        return ResponseEntity.ok(
                voucherQueryService.getAvailable(orderId)
        );
    }
}

