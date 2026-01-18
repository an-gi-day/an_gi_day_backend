package com.bqtankiet.angiday.interfaces.http.v1.category;

import com.bqtankiet.angiday.application.category.usecase.GetAllCategory;
import com.bqtankiet.angiday.application.category.usecase.GetCategoryById;
import com.bqtankiet.angiday.application.food.usecase.GetFoodsByCategoryId;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v1.food.FoodRespDto;
import com.bqtankiet.angiday.interfaces.http.v1.food.FoodRespMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bqtankiet
 */
@RequestMapping("/api/v1/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final GetAllCategory getAllCategory;
    private final CategoryResponseMapper categoryMapper;
    private final GetFoodsByCategoryId getFoodsByCategoryId;
    private final FoodRespMapper foodMapper;
    private final GetCategoryById getCategoryById;

    @GetMapping()
    public ResponseEntity<?> category() {
            var rs = getAllCategory.call();
            var dto = rs.stream()
                    .map(categoryMapper::toDto)
                    .toList();
            ApiResponse<?> apiResponse = ApiResponse.success(dto);
            apiResponse.addMetadata("size", dto.size());
            return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> categoryById(@PathVariable Long id) {
        var category = getCategoryById.call(id);
        ApiResponse<?> apiResponse = ApiResponse.success(category);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}/foods")
    public ResponseEntity<?> getFoodsByCategoryId(@PathVariable Long id) {
        var foods = getFoodsByCategoryId.call(id);
        var dto = foods.stream().map(foodMapper::toDto).toList();
        ApiResponse<?> apiResponse = ApiResponse.success(dto);
        apiResponse.addMetadata("size", dto.size());
        return ResponseEntity.ok(apiResponse);
    }
}

