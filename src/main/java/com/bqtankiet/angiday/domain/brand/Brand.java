package com.bqtankiet.angiday.domain.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private Long id;
    private String name;
    private String imageUrl;
}
