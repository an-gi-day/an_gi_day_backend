package com.bqtankiet.angiday.interfaces.http.v1.checkout.mapper;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.v1.checkout.dto.CheckoutResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderResponseMapper {

    private final ObjectMapper objectMapper;

    public CreateOrderResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public CheckoutResponse toResponse(Order order) {
        List<CheckoutResponse.OrderItemResponse> items = order.getItems().stream()
                .map(item -> new CheckoutResponse.OrderItemResponse(
                        mapFood(item.getFood()), // map domain Food → FoodResponse
                        objectMapper.valueToTree(item.getItemPricing()), // convert itemPricing to JsonNode
                        objectMapper.valueToTree(item.getOptions())     // convert options to JsonNode
                ))
                .toList();

        return new CheckoutResponse(
                order.getId(),
                items,
                objectMapper.valueToTree(order.getOrderPricing()),
                objectMapper.valueToTree(order.getPayment()),
                objectMapper.valueToTree(order.getAddress()),
                objectMapper.valueToTree(order.getAppliedVouchers()),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

    private CheckoutResponse.FoodResponse mapFood(Food food) {
        if (food == null) {
            return null;
        }
        return new CheckoutResponse.FoodResponse(
                food.getId(),
                food.getName(),
                food.getImageUrl(),
                food.getDescription()
        );
    }
}
