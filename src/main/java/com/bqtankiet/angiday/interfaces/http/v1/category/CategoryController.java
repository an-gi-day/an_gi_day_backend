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

/**
 * @author bqtankiet
 */
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
            var rs = getAllCategory.call();
            var dto = rs.stream()
                    .map(categoryMapper::modelToDto)
                    .toList();
            ApiResponse<?> apiResponse = ApiResponse.success(dto);
            apiResponse.addMetadata("size", dto.size());
            return ResponseEntity.ok(apiResponse);
    }
}

