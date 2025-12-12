package com.bqtankiet.angiday.domain.order.models;

import java.util.Objects;

public class ItemPricing {
    private int amount;
    private int optionCost;
    private int quantity;
    private int subtotal;

    public ItemPricing() {
    }

    public ItemPricing(int amount, int optionCost, int quantity, int subtotal) {
        this.amount = amount;
        this.optionCost = optionCost;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemPricing pricing)) return false;
        return amount == pricing.amount
                && optionCost == pricing.optionCost
                && quantity == pricing.quantity
                && subtotal == pricing.subtotal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, optionCost, quantity, subtotal);
    }

    // getters & setters

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOptionCost() {
        return optionCost;
    }

    public void setOptionCost(int optionCost) {
        this.optionCost = optionCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
