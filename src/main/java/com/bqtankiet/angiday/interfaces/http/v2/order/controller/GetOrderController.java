package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.mapper.OrderResponseMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(GetOrderController.ENDPOINT)
public class GetOrderController {
    public static final String ENDPOINT = "/api/v2/orders";

    private final GetOrderById getOrderById;
    private final OrderResponseMapper orderResponseMapper;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        try {
            Order order = getOrderById.execute(orderId);
            if (order == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseNotFound());
            }
            return ResponseEntity.ok().body(responseSuccess(order));
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(400, e.getMessage()));
        }
    }

    private ApiResponse<?> responseSuccess(Order order) {
        var apiResponse = ApiResponse.success(orderResponseMapper.toDto(order));
        URI location = URI.create(ENDPOINT +"/"+ order.getId());
        apiResponse.addMetadata("_links", Map.of(
                "_self", location.toString(),
                "items", location + "/items",
                "payment", location + "/payment",
                "address", location + "/address",
                "status", location + "/status"
        ));
        return apiResponse;
    }

    private ApiResponse<?> responseNotFound() {
        return ApiResponse.error(HttpStatus.NOT_FOUND.value(), "NOT_FOUND_ORDER");
    }


}
