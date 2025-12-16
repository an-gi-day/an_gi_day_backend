package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderById;
import com.bqtankiet.angiday.application.order.usecase.SaveOrderUseCase;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UpdateOrderPaymentMethodController {

    public static final String URL = "/api/v2/orders/{orderId}/payment";
    private final GetOrderById getOrderById;
    private final SaveOrderUseCase saveOrderUseCase;

    @PutMapping(URL)
    public ResponseEntity<?> updatePaymentMethod(@RequestBody Map<String, String> request, @PathVariable Long orderId){
        String paymentMethod = request.get("paymentMethod");
        try {
            validatePaymentMethod(paymentMethod);
            Order order = getAndHandleError(orderId);
            order.getPayment().setPaymentMethod(paymentMethod);
            Order updatedOrder = saveOrderUseCase.call(order);
            return ResponseEntity.ok().body(ApiResponse.success(updatedOrder.getPayment()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ApiResponse.error(404, e.getMessage())
            );
        }
    }

    @NonNull
    private Order getAndHandleError(Long orderId) {
        Order order = getOrderById.execute(orderId);
        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        return order;
    }

    private void validatePaymentMethod (String paymentMethod) throws Exception {
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Payment Method");
        }
    }
}
