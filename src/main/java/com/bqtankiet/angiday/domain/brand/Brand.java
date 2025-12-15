package com.bqtankiet.angiday.domain.brand;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * POJO Brand model
 * @author bqtankiet
 */
@Data
@AllArgsConstructor
public class Brand {

    private Long id;
    private String name;
    private String imageUrl;
}
