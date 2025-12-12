package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class AddressJpaEntity {
    @Id
    @Column(name = "address_id", nullable = false, length = 64)
    private String addressId;

    @Column(length = 20)
    private String phone;

    private double longitude;

    private double latitude;

    @Column(length = 255)
    private String location;

    @Column(length = 255)
    private String name;

    private boolean snapshot;
}
