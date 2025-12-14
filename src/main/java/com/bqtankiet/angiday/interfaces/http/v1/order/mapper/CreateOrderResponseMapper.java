package com.bqtankiet.angiday.interfaces.http.v1.order.mapper;

import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.v1.order.dto.CreateOrderResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderResponseMapper {

    private final ObjectMapper objectMapper;

    public CreateOrderResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public CreateOrderResponse toResponse(Order order) {
        List<CreateOrderResponse.OrderItemResponse> items = order.getItems().stream()
                .map(item -> new CreateOrderResponse.OrderItemResponse(
                        mapFood(item.getFood()), // map domain Food → FoodResponse
                        objectMapper.valueToTree(item.getItemPricing()), // convert itemPricing to JsonNode
                        objectMapper.valueToTree(item.getOptions())     // convert options to JsonNode
                ))
                .toList();

        return new CreateOrderResponse(
                order.getId(),
                items,
                objectMapper.valueToTree(order.getOrderPricing()),
                objectMapper.valueToTree(order.getPayment()),
                objectMapper.valueToTree(order.getAddress()),
                order.getVoucherCode(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

    private CreateOrderResponse.FoodResponse mapFood(Food food) {
        if (food == null) {
            return null;
        }
        return new CreateOrderResponse.FoodResponse(
                food.getId(),
                food.getName(),
                food.getImageUrl(),
                food.getDescription()
        );
    }
}
