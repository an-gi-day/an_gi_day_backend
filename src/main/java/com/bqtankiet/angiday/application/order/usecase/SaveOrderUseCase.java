package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveOrderUseCase {

    private final IOrderRepository orderRepository;

    @Autowired
    public SaveOrderUseCase(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order call (Order order) {
        return orderRepository.saveOrder(order).orElse(null);
    }

}
