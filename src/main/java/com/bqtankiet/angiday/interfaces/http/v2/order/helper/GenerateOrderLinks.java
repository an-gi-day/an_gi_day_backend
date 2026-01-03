package com.bqtankiet.angiday.interfaces.http.v2.order.helper;

import com.bqtankiet.angiday.interfaces.http.v2.order.controller.GetOrderController;

import java.util.Map;

public class GenerateOrderLinks {

    public static Map<String, String> generate(Long orderId) {
        String location = GetOrderController.URL + "/" +orderId;
        return Map.of(
                "order", location,
                "items", location + "/items",
                "payment", location + "/payment",
                "address", location + "/address",
                "vouchers", location + "/vouchers",
                "confirm", location + "/confirm"
        );
    }


}
