package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter @Setter
public class GeoLocation {
    private double latitude;
    private double longitude;
}


