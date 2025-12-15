package com.bqtankiet.angiday.interfaces.http.v1.checkout.dto;

public record AddressOption(
        String id,
        String phone,
        Double longitude,
        Double latitude,
        String name,
        String location,
        boolean isDefault
) {
}
