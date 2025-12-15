package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.BrandJpaEntityV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category.CategoryJpaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author bqtankiet
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods_v2")
public class FoodJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nameNoAccent; //convert ve ten khong dau
    private String description;
    private String imageUrl;
    private Double basePrice;

    private Integer soldCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryJpaEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandJpaEntityV2 brand;

    @OneToMany(
            mappedBy = "food",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<FoodOptionJpaEntity> options;
}
