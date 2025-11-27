package com.bqtankiet.angiday.infrastructure.persistence.jpa.food;

import com.bqtankiet.angiday.infrastructure.persistence.jpa.brand.BrandJpaEntity;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.category.CategoryJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bqtankiet
 */
@Entity
@Getter
@Setter
@Table(name = "foods")
public class FoodJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private Double basePrice;

    @Transient
    private Integer soldCount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryJpaEntity category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandJpaEntity brand;
}
