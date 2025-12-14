package com.bqtankiet.angiday.interfaces.http.v1.order;

import com.bqtankiet.angiday.application.order.usecase.CreateOrderUseCase;
import com.bqtankiet.angiday.application.user.usecase.GetCurrentUserId;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v1.order.dto.CreateOrderRequest;
import com.bqtankiet.angiday.interfaces.http.v1.order.mapper.CreateOrderResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final GetCurrentUserId getCurrentUserId;
    private final CreateOrderUseCase createOrderUseCase;
    private final CreateOrderResponseMapper createOrderResponseMapper;

    @Autowired
    public OrderController(GetCurrentUserId getCurrentUserId, CreateOrderUseCase createOrderUseCase, CreateOrderResponseMapper createOrderResponseMapper) {
        this.getCurrentUserId = getCurrentUserId;
        this.createOrderUseCase = createOrderUseCase;
        this.createOrderResponseMapper = createOrderResponseMapper;
    }

    /**
     * Chỉ tạo thông tin order và response về client. Chưa tạo và lưu order trong database
     */
    @PostMapping("/draft-order")
    public ResponseEntity<?> draftOrder(@RequestBody CreateOrderRequest request) {
        String userId = getCurrentUserId.call();
        Order order = createOrderUseCase.createDraft(userId, request);
        var respDto = createOrderResponseMapper.toResponse(order);
        var apiResponse = ApiResponse.success(respDto);
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Tạo và đồng thời lưu order vào database.
     */
    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody CreateOrderRequest request) {
        String userId = getCurrentUserId.call();
        if(!createOrderUseCase.existDraft(userId)) {
            return ResponseEntity.badRequest().body(
                    ApiResponse.errorWithMessage(
                            404,
                            "You must draft an order first!",
                            "Not found draft order"
                    ));
        }
        Order order = createOrderUseCase.createAndSave(userId, request);
        var respDto = createOrderResponseMapper.toResponse(order);
        var apiResponse = ApiResponse.success(respDto);
        apiResponse.setMessage("place order successfully");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/draft-order")
    public ResponseEntity<?> getDraftOrder() {
        String userId = getCurrentUserId.call();
        if (!createOrderUseCase.existDraft(userId)) {
            return ResponseEntity.badRequest().body(
                    ApiResponse.error(404, "Not found draft order")
            );
        }
        Order order = createOrderUseCase.getDraftOrder(userId);
        var respDto = createOrderResponseMapper.toResponse(order);
        var apiResponse = ApiResponse.success(respDto);
        return ResponseEntity.ok(apiResponse);
    }
}
