package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.Voucher;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.VoucherResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoucherMapper {
    VoucherResponse toResponse(Voucher voucher);
}