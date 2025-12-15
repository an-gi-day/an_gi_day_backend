package com.bqtankiet.angiday.interfaces.http.v2.service;

import com.bqtankiet.angiday.domain.order.repository.IOrderRepository;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper.OrderMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository.OrderRepositoryV2;
import com.bqtankiet.angiday.interfaces.http.v2.dto.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderQueryService {

    private final OrderRepositoryV2 orderRepository;
    private final OrderMapperV2 orderMapper;

    public OrderQueryService(OrderRepositoryV2 orderRepository, OrderMapperV2 orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderResponse getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + orderId));
    }
}