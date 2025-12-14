package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.application.food.usecase.GetAllFood;
import com.bqtankiet.angiday.application.food.usecase.SearchUseCase;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.mapper.FoodJpaMapper;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bqtankiet
 */
@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    private final GetAllFood getAllFood;
    private final FoodJpaMapper foodJpaMapper;

    private final SearchUseCase searchUseCase;

    @Autowired
    public FoodController(GetAllFood getAllFood,
                          FoodJpaMapper foodJpaMapper,
                          SearchUseCase searchUseCase) {
        this.getAllFood = getAllFood;
        this.foodJpaMapper = foodJpaMapper;
        this.searchUseCase = searchUseCase;
    }

    @GetMapping()
    public ResponseEntity<?> getAllFood() {
        var rs = getAllFood.call();
        var dto = rs.stream()
                .map(foodJpaMapper::modelToDto)
                .toList();
        var resp = ApiResponse.success(dto);
        resp.addMetadata("size", dto.size());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchFood(@RequestParam String keyword) {
        var rs = searchUseCase.call(keyword);
        var dto = rs.stream()
                .map(foodJpaMapper::modelToDto)
                .toList();

        var resp = ApiResponse.success(dto);
        resp.addMetadata("size", dto.size());
        return ResponseEntity.ok(resp);
    }

}
