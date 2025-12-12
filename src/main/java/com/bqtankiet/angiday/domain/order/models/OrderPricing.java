package com.bqtankiet.angiday.domain.order.models;

import java.util.Objects;

public class OrderPricing {
    private int amount;
    private int shipping;
    private int discount;
    private int total;

    public OrderPricing() {
    }

    public OrderPricing(int amount, int shipping, int discount, int total) {
        this.amount = amount;
        this.shipping = shipping;
        this.discount = discount;
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderPricing pricing)) return false;
        return amount == pricing.amount
                && shipping == pricing.shipping
                && discount == pricing.discount
                && total == pricing.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, shipping, discount, total);
    }

    // getters & setters

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShipping() {
        return shipping;
    }

    public void setShipping(int shipping) {
        this.shipping = shipping;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
