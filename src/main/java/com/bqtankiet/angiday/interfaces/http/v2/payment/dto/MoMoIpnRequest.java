package com.bqtankiet.angiday.interfaces.http.v2.payment.dto;

import lombok.Data;

@Data
public class MoMoIpnRequest {

    private String orderType;
    private Long amount;
    private String partnerCode;
    private String orderId;
    private String extraData;
    private String signature;
    private Long transId;
    private Long responseTime;
    private Integer resultCode;
    private String message;
    private String payType;
    private String requestId;
    private String orderInfo;
}

