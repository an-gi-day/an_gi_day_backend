package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.ConfirmOrderUseCase;
import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.mapper.OrderResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConfirmOrderController {

    public final static String URL = "/api/v2/orders/{orderId}/confirm";
    private final GetOrderById getOrderById;
    private final ConfirmOrderUseCase confirmOrderUseCase;
    private final OrderResponseMapper orderResponseMapper;

    @PostMapping(URL)
    public ResponseEntity<?> confirmOrder(@PathVariable Long orderId) {
        Order order = getOrderById.execute(orderId);
        Order confirmedOrder = confirmOrderUseCase.execute(order);
        if (confirmedOrder.confirmed()) {
            return ResponseEntity.ok().body(responseSuccess(order));
        }
        return ResponseEntity.badRequest().body(responseFailure());
    }

    private ApiResponse<?> responseFailure() {
        return ApiResponse.error(400, "Confirm Order Failed");
    }

    private ApiResponse<?> responseSuccess(Order order) {
        return ApiResponse.success(orderResponseMapper.toDto(order));
    }
}
