package com.bqtankiet.angiday.infrastructure.persistence.jpa.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_options")
@Getter
@Setter
public class ItemOptionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_id", length = 64)
    private String optionId;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String value;

    private int cost;

    private boolean snapshot;
}
