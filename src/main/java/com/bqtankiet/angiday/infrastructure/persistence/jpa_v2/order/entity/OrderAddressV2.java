package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_addresses_v2")
@Getter
@Setter
public class OrderAddressV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderV2 order;

    private String name;
    private String phone;
    private String location;

    @Embedded
    private GeoLocationV2 coordinates;
}
