package com.bqtankiet.angiday.domain.order.models;

import java.util.Objects;

public class Payment {
    private String paymentMethod;
    private String paymentStatus;
    private PaymentGateway gateway;

    public Payment() {
    }

    public Payment(String paymentMethod, String paymentStatus, PaymentGateway gateway) {
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.gateway = gateway;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(paymentMethod, payment.paymentMethod)
                && Objects.equals(paymentStatus, payment.paymentStatus)
                && Objects.equals(gateway, payment.gateway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethod, paymentStatus, gateway);
    }

    // getters & setters

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentGateway getGateway() {
        return gateway;
    }

    public void setGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }
}
