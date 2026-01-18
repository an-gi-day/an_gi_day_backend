package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.mapper;

import com.bqtankiet.angiday.domain.payment.Payment;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity.PaymentJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentJpaMapper extends DomainEntityMapper<Payment, PaymentJpaEntity> {
}
