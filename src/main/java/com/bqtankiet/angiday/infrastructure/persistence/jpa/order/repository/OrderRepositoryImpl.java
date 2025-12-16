package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.repository;

import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.repository.IOrderRepository;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.OrderJpaEntity;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper.OrderJpaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements IOrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderJpaMapper orderJpaMapper;

    @Autowired
    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository, OrderJpaMapper orderJpaMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderJpaMapper = orderJpaMapper;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderJpaRepository.findById(id).map(orderJpaMapper::toDomain);
    }

    @Override
    public Optional<Order> updateOrder(Order order) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> saveOrder(Order order) {
        System.out.println(order);
        OrderJpaEntity orderJpaEntity = orderJpaMapper.modelToDto(order);
        OrderJpaEntity savedOrder = orderJpaRepository.save(orderJpaEntity);
        return Optional.of(orderJpaMapper.toDomain(savedOrder));
    }

    @Transactional
    @Override
    public void removeOrderByUserIdAndStatus(Long userId, String status) {
        orderJpaRepository.deleteByUserIdAndStatus(userId, status);
    }
}
