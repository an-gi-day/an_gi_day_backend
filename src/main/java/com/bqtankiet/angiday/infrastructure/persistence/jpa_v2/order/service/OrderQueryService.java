package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.service;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto.OrderResponse;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.mapper.OrderMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderQueryService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderResponse getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + orderId));
    }
}