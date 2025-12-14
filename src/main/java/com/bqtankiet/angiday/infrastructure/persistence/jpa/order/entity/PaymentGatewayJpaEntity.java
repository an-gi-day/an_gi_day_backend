package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity;

import com.bqtankiet.angiday.infrastructure.persistence.converter.JpaConverterJson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name = "payment_gateways")
@Getter
@Setter
public class PaymentGatewayJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String transactionId;

    @Column(length = 255)
    private String redirectUrl;

    // Lưu extraData ở dạng JSON (cần converter)
    @Convert(converter = JpaConverterJson.class)
    @Column(columnDefinition = "TEXT")
    private Map<String, Object> extraData;
}
