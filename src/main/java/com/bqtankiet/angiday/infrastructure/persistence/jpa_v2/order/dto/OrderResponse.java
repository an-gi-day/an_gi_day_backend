package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.dto;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.OrderStatusV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.order.entity.PricingV2;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private OrderStatusV2 status;
    private PricingV2 pricing;
    private List<OrderItemResponse> items;
    private OrderPaymentResponse payment;
    private OrderAddressResponse address;
    private List<OrderVoucherResponse> vouchers;
    private Instant createdAt;
    private Instant updatedAt;
}