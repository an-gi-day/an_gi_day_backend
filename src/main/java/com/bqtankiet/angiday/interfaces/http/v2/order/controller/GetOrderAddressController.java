package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GetOrderAddressController.ENDPOINT)
@RequiredArgsConstructor
public class GetOrderAddressController {
    public static final String ENDPOINT = "/api/v2/orders/{orderId}/address";

    private final GetOrderById getOrderById;

    @GetMapping
    public ResponseEntity<?> getAddress(
            @PathVariable Long orderId
    ) {
        Order order = getOrderById.execute(orderId);
        if (order == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(responseOrderNotFound());
        }
        Address address = order.getAddress();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseSuccess(address));
    }

    private ApiResponse<?> responseSuccess(Address address) {
        return ApiResponse.success(address);
    }

    private ApiResponse<?> responseOrderNotFound() {
        return ApiResponse.error(HttpStatus.NOT_FOUND.value(), "ORDER_NOT_FOUND");
    }
}

