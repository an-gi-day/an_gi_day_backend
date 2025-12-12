package com.bqtankiet.angiday.domain.order.models;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Order {
    private String orderId;
    private List<OrderItem> items;
    private OrderPricing orderPricing;
    private Payment payment;
    private Address address;
    private String voucherCode;
    private String status;
    private Instant createdAt;

    public Order() {
    }

    public Order(String orderId,
                 List<OrderItem> items,
                 OrderPricing orderPricing,
                 Payment payment,
                 Address address,
                 String voucherCode,
                 String status,
                 Instant createdAt) {
        this.orderId = orderId;
        this.items = items;
        this.orderPricing = orderPricing;
        this.payment = payment;
        this.address = address;
        this.voucherCode = voucherCode;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(orderId, order.orderId)
                && Objects.equals(items, order.items)
                && Objects.equals(orderPricing, order.orderPricing)
                && Objects.equals(payment, order.payment)
                && Objects.equals(address, order.address)
                && Objects.equals(voucherCode, order.voucherCode)
                && Objects.equals(status, order.status)
                && Objects.equals(createdAt, order.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, items, orderPricing, payment, address, voucherCode, status, createdAt);
    }

    // getters & setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderPricing getOrderPricing() {
        return orderPricing;
    }

    public void setOrderPricing(OrderPricing orderPricing) {
        this.orderPricing = orderPricing;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
