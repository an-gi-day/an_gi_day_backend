package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import com.bqtankiet.angiday.interfaces.http.v2.others.UserAddressController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVoucherResponse {
    private Long id;
    private UserAddressController.VoucherResponse voucher;
    private long discountAmount;
}