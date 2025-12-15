package com.bqtankiet.angiday.domain.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String id;
    private String phone;
    private double longitude;
    private double latitude;
    private String location;
    private String name;
    private String userId;
    private boolean isDefault;
}

