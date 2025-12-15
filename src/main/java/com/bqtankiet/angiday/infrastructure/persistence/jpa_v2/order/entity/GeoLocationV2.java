package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter @Setter
public class GeoLocationV2 {
    private double latitude;
    private double longitude;
}


