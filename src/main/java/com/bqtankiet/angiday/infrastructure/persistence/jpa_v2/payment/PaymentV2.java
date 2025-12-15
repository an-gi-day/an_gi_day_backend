package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderV2;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "payments_v2")
@Getter @Setter
public class PaymentV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderV2 order;

    @Enumerated(EnumType.STRING)
    private PaymentMethodV2 method;

    @Enumerated(EnumType.STRING)
    private PaymentStatusV2 status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gateway_id")
    private PaymentGatewayV2 gateway;

    @CreationTimestamp
    private Instant createdAt;
}

