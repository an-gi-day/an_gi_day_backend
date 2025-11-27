package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.application.food.usecase.GetAllFood;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.FoodJpaMapper;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bqtankiet
 */
@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    private final GetAllFood getAllFood;
    private final FoodJpaMapper foodJpaMapper;

    @Autowired
    public FoodController(GetAllFood getAllFood, FoodJpaMapper foodJpaMapper) {
        this.getAllFood = getAllFood;
        this.foodJpaMapper = foodJpaMapper;
    }

    @GetMapping()
    public ResponseEntity<?> getAllFood() {
        var rs = getAllFood.call();
        var dto = rs.foods()
                .stream()
                .map(foodJpaMapper::modelToDto)
                .toList();
        var resp = ApiResponse.success(dto);
        return ResponseEntity.ok(resp);
    }

}
