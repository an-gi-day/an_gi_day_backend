package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.GeoLocation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderAddressResponse {
    private Long id;
    private String name;
    private String phone;
    private String location;
    private GeoLocation coordinates;
}