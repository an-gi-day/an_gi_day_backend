package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
    private String orderId;  // theo định dạng OyyyyMMddHHmmss

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItemJpaEntity> items;

    @Embedded
    private OrderPricingEmbed orderPricing;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentJpaEntity payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressJpaEntity address;

    private String voucherCode;

    private String status;

    private Instant createdAt;
}
