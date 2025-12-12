package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class PaymentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khoá chính tự sinh

    @Column(length = 50)
    private String paymentMethod;

    @Column(length = 50)
    private String paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gateway_id")
    private PaymentGatewayJpaEntity gateway;

}
