package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.VoucherV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.VoucherResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoucherMapperV2 {
    VoucherResponse toResponse(VoucherV2 voucher);
}