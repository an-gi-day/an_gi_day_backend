package com.bqtankiet.angiday.interfaces.http.v2.order.controller;

import com.bqtankiet.angiday.application.order.command.DraftOrderCommand;
import com.bqtankiet.angiday.application.order.exception.CreateOrderException;
import com.bqtankiet.angiday.application.order.usecase.CheckoutOrderUseCase;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.CreateDraftOrderRequest;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.OrderResponse;
import com.bqtankiet.angiday.interfaces.http.v2.order.helper.GenerateOrderLinks;
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

@RestController
@RequestMapping(CreateOrderDraftController.URL)
@RequiredArgsConstructor
public class CreateOrderDraftController {
    public static final String URL = "/api/v2/orders";

    private final CheckoutOrderUseCase checkoutOrderUseCase;
    private final DraftOrderCommandMapper draftOrderCommandMapper;
    private final OrderResponseMapper orderResponseMapper;

    @PostMapping("/")
    public ResponseEntity<?> createOrder(
            @RequestBody CreateDraftOrderRequest request
    ) {
        try {
            Order order = createDraftOrder(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseSuccess(order));
        } catch (CreateOrderException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError(e));
        }
    }

    private static ApiResponse<Object> responseError(CreateOrderException e) {
        return ApiResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    private ApiResponse<?> responseSuccess(Order order) {
        OrderResponse orderResponse = orderResponseMapper.toDto(order);
        ApiResponse<?> apiResponse = ApiResponse.success(orderResponse);
        apiResponse.addMetadata("_links", GenerateOrderLinks.generate(order.getId()));
        URI location = getLocation(order.getId());
        ResponseEntity.created(location).body(apiResponse);
        return apiResponse;
    }

    private Order createDraftOrder(CreateDraftOrderRequest request) {
        DraftOrderCommand command = draftOrderCommandMapper.fromRequest(request);
        return checkoutOrderUseCase.draftOrder(command);
    }

    private URI getLocation(Long orderId) {
        return URI.create(URL + "/" + orderId);
    }

}
