package com.bqtankiet.angiday.domain.order.models;

import java.util.Map;
import java.util.Objects;

public class PaymentGateway {
    private String name;
    private String transactionId;
    private String redirectUrl;
    private Map<String, Object> extraData;

    public PaymentGateway() {
    }

    public PaymentGateway(String name, String transactionId, String redirectUrl, Map<String, Object> extraData) {
        this.name = name;
        this.transactionId = transactionId;
        this.redirectUrl = redirectUrl;
        this.extraData = extraData;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentGateway gateway)) return false;
        return Objects.equals(name, gateway.name)
                && Objects.equals(transactionId, gateway.transactionId)
                && Objects.equals(redirectUrl, gateway.redirectUrl)
                && Objects.equals(extraData, gateway.extraData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, transactionId, redirectUrl, extraData);
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }
}
