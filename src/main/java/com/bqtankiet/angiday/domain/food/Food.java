package com.bqtankiet.angiday.domain.food;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.category.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * POJO Food model
 *
 * @author bqtankiet
 */
@Data
public class Food {

    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private Double basePrice;
    private Category category;
    private Brand brand;
    private Integer soldCount;
    private List<FoodOption> options;

    public List<FoodOptionValue> getOptionValuesByIds(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        return options.stream()
                .flatMap(o -> o.getOptionValues().stream())
                .filter(v -> ids.contains(v.getId()))
                .toList();
    }

}
