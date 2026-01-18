package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity;

import com.bqtankiet.angiday.domain.food.FoodOption;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.brand.BrandJpaEntity;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.category.CategoryJpaEntity;
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
@Table(name = "foods")
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
    private BrandJpaEntity brand;

    @OneToMany(
            mappedBy = "food",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<FoodOptionJpaEntity> options;
}
