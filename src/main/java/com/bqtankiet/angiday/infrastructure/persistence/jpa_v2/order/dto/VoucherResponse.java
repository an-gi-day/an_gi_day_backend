package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class VoucherResponse {
    private Long id;
    private String code;
    private long discountValue;
    private Instant expiredAt;
}