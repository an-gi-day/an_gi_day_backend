package com.bqtankiet.angiday.domain.order.models;

import com.bqtankiet.angiday.domain.address.Address;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private String id;
    private List<OrderItem> items;
    private OrderPricing orderPricing;
    private Payment payment;
    private Address address;
    private List<Voucher> appliedVouchers;
    private String userId;
    private String status;
    private Instant createdAt;

    public Order(String userId) {
        this.userId = userId;
        this.orderPricing = new OrderPricing();
        this.appliedVouchers = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public boolean addItem(OrderItem orderItem) {
        this.orderPricing.updatePricing(orderItem);
        return items.add(orderItem);
    }
}
