package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bqtankiet
 */
@Entity
@Getter
@Setter
@Table(name = "brands_v2")
public class BrandJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;
}
