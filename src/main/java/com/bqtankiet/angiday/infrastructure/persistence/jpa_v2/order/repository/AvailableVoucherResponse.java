package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.VoucherResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AvailableVoucherResponse {
    private List<VoucherResponse> available;
}