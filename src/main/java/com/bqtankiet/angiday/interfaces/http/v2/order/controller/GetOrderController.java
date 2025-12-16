package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.mapper.OrderResponseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class GetOrderController {

    private final GetOrderById getOrderById;
    private final OrderResponseMapper orderResponseMapper;

    public GetOrderController(GetOrderById getOrderById, OrderResponseMapper orderResponseMapper) {
        this.getOrderById = getOrderById;
        this.orderResponseMapper = orderResponseMapper;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        try {
            Order order = getOrderById.execute(orderId);
            if (order == null) {
                return ResponseEntity
                        .status(404)
                        .body(ApiResponse.error(404, "NOT_FOUND_ORDER"));
            }
            var apiResponse = ApiResponse.success(orderResponseMapper.toDto(order));
            String baseUrl = "/api/v1/orders";
            URI location = URI.create(String.format("%s/%d", baseUrl, order.getId()));
            apiResponse.addMetadata("_links", Map.of(
                    "self", location.toString(),
                    "items", location + "/items",
                    "payment", location + "/payment",
                    "address", location + "/address",
                    "status", location + "/status"
            ));
            return ResponseEntity.ok().body(apiResponse);
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(400, e.getMessage()));
        }
    }


}
