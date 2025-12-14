package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.application.address.usecase.GetAddressById;
import com.bqtankiet.angiday.application.food.usecase.GetFoodById;
import com.bqtankiet.angiday.domain.food.Food;
import com.bqtankiet.angiday.domain.food.FoodOptionValue;
import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.models.OrderItem;
import com.bqtankiet.angiday.domain.order.models.Payment;
import com.bqtankiet.angiday.interfaces.http.v1.order.dto.CreateOrderRequest;
import com.bqtankiet.angiday.interfaces.http.v1.order.dto.OrderItemRequest;
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

    private final Map<String, Order> draftOrdersCache = new HashMap<>();

    @Autowired
    public CreateOrderUseCase(GetFoodById getFoodById, SaveOrderUseCase saveOrderUseCase, GetAddressById getAddressById) {
        this.getFoodById = getFoodById;
        this.saveOrderUseCase = saveOrderUseCase;
        this.getAddressById = getAddressById;
    }

    public Order createDraft(String userId, CreateOrderRequest request){

        Order order = new Order(userId);

        for (OrderItemRequest itemRequest: request.items()) {
            Food food = getFoodById.call(itemRequest.foodId());
            List<FoodOptionValue> selectedOptions = food.getOptionValuesByIds(itemRequest.optionIds());

            OrderItem orderItem = OrderItem.create(
                    food,
                    itemRequest.quantity(),
                    selectedOptions
            );

            order.addItem(orderItem); // return true if added successfully
        }

        Payment payment = Payment.create(request.paymentMethod());
        order.setPayment(payment);

        order.setVoucherCode(request.voucherCode());

        order.setStatus("DRAFT");

        Address address = getAddressById.call(request.addressId());
        order.setAddress(address);

        // Cache draft order
        draftOrdersCache.put(userId, order);

        return order;
    }

    public Order createAndSave(String userId, CreateOrderRequest request){
        Order order = createDraft(userId, request);
        order.setStatus("ACCEPTED");
        var savedOrder = saveOrderUseCase.call(order);

        // Remove cache after the order is successfully created
        if(savedOrder != null) {
            draftOrdersCache.remove(userId);
        }
        return savedOrder;
    }

    public boolean existDraft(String userId) {
        return  draftOrdersCache.containsKey(userId);
    }

    public Order getDraftOrder(String userId) {
        return draftOrdersCache.get(userId);
    }
}
