package com.bqtankiet.angiday.interfaces.http.v2.controller;

import com.bqtankiet.angiday.interfaces.http.v2.dto.UserAddressesResponse;
import com.bqtankiet.angiday.interfaces.http.v2.service.UserAddressQueryService;
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

