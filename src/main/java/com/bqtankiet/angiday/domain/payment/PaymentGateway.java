package com.bqtankiet.angiday.domain.payment;

import lombok.Data;

import java.util.Map;

@Data
public class PaymentGateway {
    protected Long id;
    protected String name;
    protected String transactionId;
    protected String appUrl;
    protected String webUrl;
    protected Map<String, Object> extraData;

}
