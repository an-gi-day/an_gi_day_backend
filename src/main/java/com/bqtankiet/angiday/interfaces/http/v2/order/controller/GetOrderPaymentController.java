package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.domain.payment.Payment;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderPaymentResponse;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GetOrderPaymentController.URL)
@RequiredArgsConstructor
public class GetOrderPaymentController {
    public static final String URL = "/api/v2/orders/{orderId}/payment";


    private final GetOrderById getOrderById;

    @GetMapping
    public ResponseEntity<?> getPayment(
            @PathVariable Long orderId
    ) {
        Order order = getOrderById.execute(orderId);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseOrderNotFound());
        }
        Payment payment = order.getPayment();
        return ResponseEntity.status(HttpStatus.OK).body(responseSuccess(payment));
    }

    private ApiResponse<?> responseSuccess(Payment payment) {
        return ApiResponse.success(payment);
    }

    private ApiResponse<?> responseOrderNotFound() {
        return ApiResponse.error(HttpStatus.NOT_FOUND.value(), "ORDER_NOT_FOUND");
    }

}

