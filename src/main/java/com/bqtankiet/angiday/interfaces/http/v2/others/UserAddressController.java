package com.bqtankiet.angiday.interfaces.http.v2.others;

import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderAddressResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

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

    @Getter
    @Setter
    public static class UserAddressesResponse {
        private List<OrderAddressResponse> addresses;
    }

    @Getter
    @Setter
    public static class VoucherResponse {
        private Long id;
        private String code;
        private long discountValue;
        private Instant expiredAt;
    }
}

