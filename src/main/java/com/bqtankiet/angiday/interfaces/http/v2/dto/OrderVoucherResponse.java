package com.bqtankiet.angiday.interfaces.http.v2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVoucherResponse {
    private Long id;
    private VoucherResponse voucher;
    private long discountAmount;
}