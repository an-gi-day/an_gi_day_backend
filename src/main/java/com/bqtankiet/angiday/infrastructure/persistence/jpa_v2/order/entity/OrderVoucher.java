package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_vouchers_v2")
@Getter
@Setter
public class OrderVoucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    private long discountAmount;
}

