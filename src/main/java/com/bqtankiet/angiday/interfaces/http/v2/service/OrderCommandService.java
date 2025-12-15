package com.bqtankiet.angiday.interfaces.http.v2.service;
import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderStatusResponse;
import com.bqtankiet.angiday.interfaces.http.v2.dto.UpdateOrderStatusRequest;
import org.springframework.stereotype.Service;

@Service

public class OrderCommandService {
    public OrderStatusResponse updateStatus(Long orderId, UpdateOrderStatusRequest request) {
        return null;
    }
}
