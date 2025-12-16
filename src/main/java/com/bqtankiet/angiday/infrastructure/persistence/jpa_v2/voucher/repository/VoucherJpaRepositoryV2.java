package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.voucher.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.voucher.entity.VoucherJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherJpaRepositoryV2 extends JpaRepository<VoucherJpaEntityV2, Long> {
    // thêm query tuỳ ý nếu cần
}