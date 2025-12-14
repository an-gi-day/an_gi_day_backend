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
    private String voucherCode;
    private String userId;
    private String status;
    private Instant createdAt;

    public Order(String userId) {
        this.userId = userId;
        this.orderPricing = new OrderPricing();
    }

    public boolean addItem(OrderItem orderItem) {
        if (this.items == null) {this.items = new ArrayList<>();}
        this.orderPricing.updatePricing(orderItem);
        return items.add(orderItem);
    }
}
