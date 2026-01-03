package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderAddressResponse {
    private Long id;
    private String name;
    private String phone;
    private String location;
}