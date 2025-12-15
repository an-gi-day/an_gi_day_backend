package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.AvailableVoucherResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.VoucherQueryService;
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
    public ResponseEntity<AvailableVoucherResponse> getAvailable(
            @RequestParam Long orderId
    ) {
        return ResponseEntity.ok(
                voucherQueryService.getAvailable(orderId)
        );
    }
}

