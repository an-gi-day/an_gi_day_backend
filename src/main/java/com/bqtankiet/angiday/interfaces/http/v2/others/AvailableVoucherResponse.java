package com.bqtankiet.angiday.interfaces.http.v2.others;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AvailableVoucherResponse {
    private List<UserAddressController.VoucherResponse> available;
}