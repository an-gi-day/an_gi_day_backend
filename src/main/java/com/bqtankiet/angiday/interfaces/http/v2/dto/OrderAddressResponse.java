package com.bqtankiet.angiday.interfaces.http.v2.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.GeoLocationV2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderAddressResponse {
    private Long id;
    private String name;
    private String phone;
    private String location;
    private GeoLocationV2 coordinates;
}