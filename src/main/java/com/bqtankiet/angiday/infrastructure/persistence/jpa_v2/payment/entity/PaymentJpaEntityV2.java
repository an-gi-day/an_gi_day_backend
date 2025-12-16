package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment.entity;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderV2;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "payments_v2")
@Getter @Setter
public class PaymentJpaEntityV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderV2 order;

    @Enumerated(EnumType.STRING)
    private PaymentMethodJpaEntityV2 method;

    @Enumerated(EnumType.STRING)
    private PaymentStatusJpaEntityV2 status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gateway_id")
    private PaymentGatewayJpaEntityV2 gateway;

    @CreationTimestamp
    private Instant createdAt;
}

