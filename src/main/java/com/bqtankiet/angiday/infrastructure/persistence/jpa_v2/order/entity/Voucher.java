package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "vouchers_v2")
@Getter @Setter
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private long discountValue;
    private Instant expiredAt;
}

