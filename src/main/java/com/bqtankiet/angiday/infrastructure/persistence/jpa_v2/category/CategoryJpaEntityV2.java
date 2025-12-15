package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.category;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bqtankiet
 */
@Entity
@Getter
@Setter
@Table(name = "categories_v2")
public class CategoryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;
}

