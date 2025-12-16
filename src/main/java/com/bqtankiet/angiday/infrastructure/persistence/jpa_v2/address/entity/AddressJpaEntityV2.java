package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses_v2")
@Getter
@Setter
public class AddressJpaEntityV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String phone;

    private double longitude;

    private double latitude;

    private String location;

    private String name;

    private Long userId;

    private Boolean isDefault;
}
