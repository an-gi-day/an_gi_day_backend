package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.controller;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.UserAddressesResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service.UserAddressQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/addresses")
@RequiredArgsConstructor
public class UserAddressController {

    private final UserAddressQueryService addressQueryService;

    @GetMapping
    public ResponseEntity<UserAddressesResponse> getAddresses(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(
                addressQueryService.getAddresses(userId)
        );
    }
}

