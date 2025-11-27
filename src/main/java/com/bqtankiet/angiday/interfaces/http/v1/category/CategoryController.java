package com.bqtankiet.angiday.interfaces.http.v1.category;

import com.bqtankiet.angiday.application.category.usecase.GetAllCategory;
import com.bqtankiet.angiday.domain.category.Category;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {
    private final GetAllCategory getAllCategory;
    private final CategoryResponseMapper categoryMapper;

    @Autowired
    public CategoryController(GetAllCategory getAllCategory, CategoryResponseMapper categoryMapper) {
        this.getAllCategory = getAllCategory;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping()
    public ResponseEntity<?> category() {
            List<Category> categories = getAllCategory
                    .with(null)
                    .call()
                    .categories();
            List<CategoryResponseDto> dtoList = categories.stream()
                    .map(categoryMapper::modelToDto)
                    .toList();
            ApiResponse<List<CategoryResponseDto>> apiResponse = ApiResponse.success(dtoList);
            apiResponse.setMetadata(Map.of("size", categories.size()));
            return ResponseEntity.ok(apiResponse);
    }
}

