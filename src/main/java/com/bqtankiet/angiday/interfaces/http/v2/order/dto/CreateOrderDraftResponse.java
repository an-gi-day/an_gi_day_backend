package com.bqtankiet.angiday.interfaces.http.v2.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CreateOrderDraftResponse {

    private Long id;
    private String status;
    private Instant createdAt;

}
