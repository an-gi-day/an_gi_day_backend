package com.bqtankiet.angiday.application.order.exception;

public class CreateOrderException extends RuntimeException {
    public static final CreateOrderException INVALID_PAYMENT_METHOD = new CreateOrderException("INVALID_PAYMENT_METHOD");;
    public static final CreateOrderException ORDER_NOT_FOUND = new CreateOrderException("ORDER_NOT_FOUND");
    public static final CreateOrderException CREATE_ORDER_FAILED = new CreateOrderException("CREATE_ORDER_FAILED");
    public static final CreateOrderException INVALID_ADDRESS = new CreateOrderException("INVALID_ADDRESS");
    public static final CreateOrderException EMPTY_ITEMS = new CreateOrderException("EMPTY_ITEMS");

    public CreateOrderException(String message) {
        super(message);
    }
}
