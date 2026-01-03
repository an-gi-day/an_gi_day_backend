package com.bqtankiet.angiday.domain.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long id;
    private String phone;
    private double longitude;
    private double latitude;
    private String location;
    private String name;
    private Long userId;
    private boolean isDefault;

    public boolean isValid() {
        return id != null && phone!=null && userId != null;
    }
}

