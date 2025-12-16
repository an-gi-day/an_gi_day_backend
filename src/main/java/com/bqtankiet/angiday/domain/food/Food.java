package com.bqtankiet.angiday.domain.food;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private Double basePrice;
    private Category category;
    private Brand brand;
    private Integer soldCount;
    private List<FoodOption> options;

    public List<FoodOptionValue> getOptionValuesByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        return options.stream()
                .flatMap(o -> o.getOptionValues().stream())
                .filter(v -> ids.contains(v.getId()))
                .toList();
    }

}
