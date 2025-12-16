package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.voucher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepositoryV2 extends JpaRepository<VoucherV2, Long> {
    // thêm query tuỳ ý nếu cần
}