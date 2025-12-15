package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address;

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

    @Column(length = 255)
    private String location;

    @Column(length = 255)
    private String name;

    private String userId;

    private Boolean isDefault;
}
