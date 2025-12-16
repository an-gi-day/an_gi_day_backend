package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.voucher.entity.VoucherJpaEntityV2;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_vouchers_v2")
@Getter
@Setter
public class OrderVoucherV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderV2 order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private VoucherJpaEntityV2 voucher;

    private long discountAmount;
}

