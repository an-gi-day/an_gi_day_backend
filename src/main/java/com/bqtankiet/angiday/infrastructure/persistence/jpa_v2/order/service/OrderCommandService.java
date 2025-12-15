package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderStatusResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.UpdateOrderStatusRequest;
import org.springframework.stereotype.Service;

@Service

public class OrderCommandService {
    public OrderStatusResponse updateStatus(Long orderId, UpdateOrderStatusRequest request) {
        return null;
    }
}
