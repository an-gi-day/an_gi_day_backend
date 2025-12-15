package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.PaymentOptionsResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.PaymentOptionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment-options")
@RequiredArgsConstructor
public class PaymentOptionController {

    private final PaymentOptionQueryService paymentOptionQueryService;

    @GetMapping
    public ResponseEntity<PaymentOptionsResponse> getOptions() {
        return ResponseEntity.ok(
                paymentOptionQueryService.getOptions()
        );
    }
}

