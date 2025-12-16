package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.repository.IOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class GetOrderById {
    private final IOrderRepository orderRepository;

    public GetOrderById(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order execute(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

}
