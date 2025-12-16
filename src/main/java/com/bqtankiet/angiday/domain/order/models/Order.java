package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.payment.Payment;
import com.bqtankiet.angiday.domain.voucher.Voucher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private List<OrderItem> items;
    private OrderPricing orderPricing;
    private Payment payment;
    private Address address;
    private List<Voucher> appliedVouchers;
    private Long userId;
    private String status;
    private Instant createdAt;

    public Order(Long userId) {
        this.userId = userId;
        this.orderPricing = new OrderPricing();
        this.appliedVouchers = new ArrayList<>();
        this.items = new ArrayList<>();
        this.createdAt = Instant.now();
    }

    public boolean addItem(OrderItem orderItem) {
        this.orderPricing.updatePricing(orderItem);
        return items.add(orderItem);
    }

}
