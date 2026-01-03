package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.payment.PaymentGateway;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.PaymentGatewayJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentGatewayJpaMapper extends DomainEntityMapper<PaymentGateway, PaymentGatewayJpaEntity> {
}