package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.order.models.PaymentGateway;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.PaymentGatewayJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentGatewayJpaMapper extends JpaMapper<PaymentGateway, PaymentGatewayJpaEntity> {
}