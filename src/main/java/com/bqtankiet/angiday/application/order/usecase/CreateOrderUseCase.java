package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.application.address.usecase.GetAddressById;
import com.bqtankiet.angiday.application.food.usecase.GetFoodById;
import com.bqtankiet.angiday.application.order.exception.CreateOrderException;
import com.bqtankiet.angiday.application.temp.GetPaymentOptionsUseCase;
import com.bqtankiet.angiday.application.temp.PaymentGatewayService;
import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.domain.payment.Payment;
import com.bqtankiet.angiday.domain.payment.PaymentGateway;
import com.bqtankiet.angiday.interfaces.http.v1.checkout.dto.CheckoutRequest;
import com.bqtankiet.angiday.interfaces.http.v1.checkout.dto.OrderItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreateOrderUseCase {

    private final GetFoodById getFoodById;
    private final SaveOrderUseCase saveOrderUseCase;
    private final GetAddressById getAddressById;
    private final PaymentGatewayService paymentGatewayService;

    private final Map<Long, Order> draftOrdersCache = new HashMap<>();
    private final GetPaymentOptionsUseCase getPaymentOptionsUseCase;

    @Autowired
    public CreateOrderUseCase(GetFoodById getFoodById, SaveOrderUseCase saveOrderUseCase, GetAddressById getAddressById, PaymentGatewayService paymentGatewayService, GetPaymentOptionsUseCase getPaymentOptionsUseCase) {
        this.getFoodById = getFoodById;
        this.saveOrderUseCase = saveOrderUseCase;
        this.getAddressById = getAddressById;
        this.paymentGatewayService = paymentGatewayService;
        this.getPaymentOptionsUseCase = getPaymentOptionsUseCase;
    }

    public Order createDraft(Long userId, CheckoutRequest request) {

        Order order = new Order(userId);

        for (OrderItemRequest itemRequest : request.items()) {
            Food food = getFoodById.call(itemRequest.foodId());
            List<FoodOptionValue> selectedOptions = food.getOptionValuesByIds(itemRequest.optionIds());

            OrderItem orderItem = OrderItem.create(
                    food,
                    itemRequest.quantity(),
                    selectedOptions
            );

            order.addItem(orderItem); // return true if added successfully
        }
        order.setStatus("DRAFT");

        // Cache draft order
        draftOrdersCache.put(userId, order);

        return order;
    }

    public Order confirmAndSave(Long userId) throws CreateOrderException {
        Order order = getDraftOrder(userId);
        order.setStatus("CONFIRMED");
        Order savedOrder = saveOrderUseCase.call(order);
        if (savedOrder == null) {
            throw CreateOrderException.CREATE_ORDER_FAILED;
        }
        return savedOrder;
    }

    public boolean existDraft(Long userId) {
        return draftOrdersCache.containsKey(userId);
    }

    public Order getDraftOrder(Long userId) throws CreateOrderException {
        Order order = draftOrdersCache.get(userId);
        if (order == null) {
            throw CreateOrderException.ORDER_NOT_FOUND;
        }
        return order;
    }

    public Payment updatePayment(Long userId, String paymentMethod) throws CreateOrderException {
        if (getDraftOrder(userId) == null) {
            throw CreateOrderException.ORDER_NOT_FOUND;
        }
        if (paymentMethod == null || !getPaymentOptionsUseCase.isValidMethod(paymentMethod)) {
            throw CreateOrderException.INVALID_PAYMENT_METHOD;
        }
        Payment payment = Payment.create(paymentMethod);
        getDraftOrder(userId).setPayment(payment);
        return payment;
    }

    public Address updateAddress(Long userId, Long addressId) throws CreateOrderException {

        Order draftOrder = getDraftOrder(userId);
        if (draftOrder == null) {
            throw CreateOrderException.ORDER_NOT_FOUND;
        }

        Address address = getAddressById.call(addressId);
        if (address == null) {
            throw CreateOrderException.INVALID_ADDRESS;
        }

        draftOrder.setAddress(address);
        return address;
    }

    public Order confirmOrder(Long userId) throws CreateOrderException {
        Order order = getDraftOrder(userId);
        if (order == null) {
            throw CreateOrderException.ORDER_NOT_FOUND;
        }
        if (order.getAddress() == null) {
            throw CreateOrderException.INVALID_ADDRESS;
        }
        if (order.getPayment() == null) {
            throw CreateOrderException.INVALID_PAYMENT_METHOD;
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw CreateOrderException.EMPTY_ITEMS;
        }
        String paymentMethod = order.getPayment().getPaymentMethod();

        Order savedOrder = confirmAndSave(userId);
        if ("cash".equals(paymentMethod)) {
            return savedOrder;
        }
        PaymentGateway paymentGateway = paymentGatewayService.create(paymentMethod, order);
        savedOrder.getPayment().setGateway(paymentGateway);
        savedOrder = saveOrderUseCase.call(savedOrder); // save with updated payment gateway
        draftOrdersCache.put(userId, savedOrder); // update cache
        return savedOrder;
    }
}
