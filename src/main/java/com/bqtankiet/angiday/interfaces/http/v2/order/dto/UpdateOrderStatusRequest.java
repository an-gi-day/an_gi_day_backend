package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderStatusRequest {
    private String status;
}