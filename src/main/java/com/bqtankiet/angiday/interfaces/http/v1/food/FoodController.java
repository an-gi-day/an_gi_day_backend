package com.bqtankiet.angiday.interfaces.http.v1.food;

import com.bqtankiet.angiday.application.food.usecase.GetAllFood;
import com.bqtankiet.angiday.application.food.usecase.GetFoodById;
import com.bqtankiet.angiday.application.food.usecase.SearchUseCase;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.mapper.FoodJpaMapper;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bqtankiet
 */
@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    private final GetAllFood getAllFood;
    private final GetFoodById getFoodById;
    private final FoodRespMapper foodRespMapper;
    private final FoodWithOptionsMapper foodWithOptionsMapper;
    private final SearchUseCase searchUseCase;

    @Autowired
    public FoodController(GetAllFood getAllFood,
                          GetFoodById getFoodById,
                          FoodRespMapper foodRespMapper,
                          FoodWithOptionsMapper foodWithOptionsMapper,
                          SearchUseCase searchUseCase) {
        this.getAllFood = getAllFood;
        this.getFoodById = getFoodById;
        this.foodRespMapper = foodRespMapper;
        this.foodWithOptionsMapper = foodWithOptionsMapper;
        this.searchUseCase = searchUseCase;
    }

    /**
     * Lấy danh sách tất cả foods trong database
     */
    @GetMapping()
    public ResponseEntity<?> getAllFood() {
        var rs = getAllFood.call();
        var dto = rs.stream()
                .map(foodRespMapper::modelToDto)
                .toList();
        var resp = ApiResponse.success(dto);
        resp.addMetadata("size", dto.size());
        return ResponseEntity.ok(resp);
    }

    /**
     * Lấy food theo id
     */
    @GetMapping("/{foodId}")
    public ResponseEntity<?> getFoodById(@PathVariable String foodId) {
        Food food = getFoodById.call(foodId);

        // FAILED: Not found with id
        if (food == null) {
            return ResponseEntity.ok(
                    ApiResponse.error(404, "Not found with id: "+foodId));
        }

        // SUCCESS
        var foodDto = foodWithOptionsMapper.modelToDto(food);
        return ResponseEntity.ok(ApiResponse.success(foodDto));
    }

    /**
     * Tìm kiếm foods theo keyword
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchFood(@RequestParam String keyword) {
        var rs = searchUseCase.call(keyword);
        var dto = rs.stream()
                .map(foodRespMapper::modelToDto)
                .toList();

        var resp = ApiResponse.success(dto);
        resp.addMetadata("size", dto.size());
        return ResponseEntity.ok(resp);
    }

}
