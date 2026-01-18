package com.bqtankiet.angiday.infrastructure.payment.momo.mservice.models;

import com.bqtankiet.angiday.infrastructure.payment.momo.mservice.enums.ConfirmRequestType;

public class ConfirmResponse extends Response {
    private Long amount;
    private Long transId;
    private String requestId;
    private ConfirmRequestType requestType;
}
