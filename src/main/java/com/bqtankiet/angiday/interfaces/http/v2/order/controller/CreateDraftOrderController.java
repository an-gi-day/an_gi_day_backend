package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.exception.CreateOrderException;
import com.bqtankiet.angiday.application.order.usecase.CheckoutOrderUseCase;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.CreateDraftOrderRequest;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.mapper.DraftOrderCommandMapper;
import com.bqtankiet.angiday.interfaces.http.v2.order.mapper.OrderResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class CreateDraftOrderController {

    private final CheckoutOrderUseCase checkoutOrderUseCase;
    private final DraftOrderCommandMapper draftOrderCommandMapper;
    private final OrderResponseMapper orderResponseMapper;

    @PostMapping("/")
    public ResponseEntity<?> createOrder(
            @RequestBody CreateDraftOrderRequest request
    ) {
        try {
            Order order = checkoutOrderUseCase.draftOrder(draftOrderCommandMapper.fromRequest(request));
            OrderResponse orderResponse = orderResponseMapper.toDto(order);
            var apiResponse = ApiResponse.success(orderResponse);
            String baseUrl = "/api/v1/orders";
            URI location = URI.create(String.format("%s/%d", baseUrl, order.getId()));
            apiResponse.addMetadata("_links", Map.of(
                    "self", location.toString(),
                    "items", location + "/items",
                    "payment", location + "/payment",
                    "address", location + "/address",
                    "status", location + "/status"
            ));
            return ResponseEntity.created(location).body(apiResponse);
        } catch (CreateOrderException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }
}
