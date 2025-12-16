package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity.PaymentJpaEntityV2;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders_v2")
@Getter
@Setter
public class OrderV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatusV2 status;

    @Embedded
    private OrderPricingV2 pricing;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<OrderItemV2> items = new ArrayList<>();

    @OneToOne(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private PaymentJpaEntityV2 payment;

    @OneToOne(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private OrderAddressV2 address;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderVoucherV2> vouchers = new ArrayList<>();

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}
