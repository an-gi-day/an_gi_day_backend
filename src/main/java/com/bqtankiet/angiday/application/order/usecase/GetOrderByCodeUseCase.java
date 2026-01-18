package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetOrderByCodeUseCase {

    private final IOrderRepository orderRepository;

    public Order execute(String code) {
        Order order = orderRepository.findByCode(code).orElseThrow();
        return order;
    }

}
