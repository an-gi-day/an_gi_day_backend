package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVoucherResponse {
    private Long id;
    private VoucherResponse voucher;
    private long discountAmount;
}