package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(GetOrderItemController.URL)
@RequiredArgsConstructor
public class GetOrderItemController {
    public static final  String URL = "/api/v2/orders/{orderId}/items";
    private final GetOrderById getOrderById;

    @GetMapping()
    public ResponseEntity<?> getItems(
            @PathVariable Long orderId
    ) {
        Order order = getOrderById.execute(orderId);
        if(order==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseOrderNotFound());
        }
        List<OrderItem> items = order.getItems();
        return ResponseEntity.status(HttpStatus.OK).body(responseSuccess(items));
    }

    private ApiResponse<?> responseSuccess(List<OrderItem> items) {
        return ApiResponse.success(items);
    }

    private ApiResponse<?> responseOrderNotFound() {
        return ApiResponse.error(HttpStatus.NOT_FOUND.value(), "ORDER_NOT_FOUND");
    }
}

