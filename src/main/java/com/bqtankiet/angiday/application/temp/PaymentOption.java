package com.bqtankiet.angiday.application.temp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentOption {
    String method;
    String type;
}
