package com.bqtankiet.angiday.domain.order.models;

import java.util.Objects;

public class ItemOption {
    private String optionId;
    private String name;
    private String value;
    private int cost;
    private boolean snapshot;

    public ItemOption() {
    }

    public ItemOption(String optionId, String name, String value, int cost, boolean snapshot) {
        this.optionId = optionId;
        this.name = name;
        this.value = value;
        this.cost = cost;
        this.snapshot = snapshot;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemOption option)) return false;
        return cost == option.cost
                && snapshot == option.snapshot
                && Objects.equals(optionId, option.optionId)
                && Objects.equals(name, option.name)
                && Objects.equals(value, option.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionId, name, value, cost, snapshot);
    }

    // getters & setters

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    public void setSnapshot(boolean snapshot) {
        this.snapshot = snapshot;
    }
}
