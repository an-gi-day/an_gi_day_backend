package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.payment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_gateways_v2")
@Getter
@Setter
public class PaymentGatewayV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String appUrl;
    private String webUrl;
}

