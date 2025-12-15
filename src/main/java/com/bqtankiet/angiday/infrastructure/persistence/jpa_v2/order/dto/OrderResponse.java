package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderStatus;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.Pricing;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private OrderStatus status;
    private Pricing pricing;
    private List<OrderItemResponse> items;
    private OrderPaymentResponse payment;
    private OrderAddressResponse address;
    private List<OrderVoucherResponse> vouchers;
    private Instant createdAt;
    private Instant updatedAt;
}