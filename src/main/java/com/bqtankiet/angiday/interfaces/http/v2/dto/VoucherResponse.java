package com.bqtankiet.angiday.interfaces.http.v2.dto;

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