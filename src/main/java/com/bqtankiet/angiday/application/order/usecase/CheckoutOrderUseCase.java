package com.bqtankiet.angiday.application.order.usecase;

import com.bqtankiet.angiday.application.order.command.DraftOrderCommand;
import com.bqtankiet.angiday.application.order.exception.CreateOrderException;
import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.order.repository.IOrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CheckoutOrderUseCase {

    private final IOrderRepository orderRepository;
    private final IAddressRepository addressRepository;

    @Autowired
    public CheckoutOrderUseCase(IOrderRepository orderRepository,
                                @Qualifier("AddressRepositoryImpl")
                                IAddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
    }

    public Order draftOrder(DraftOrderCommand command) {
        validate(command);
        Long userId = command.getUserId();

        try {
            orderRepository.removeOrderByUserIdAndStatus(userId, "DRAFT");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        Address address = addressRepository.getDefaultAddress(userId).orElse(new Address());

        Order order = new Order();
        order.setUserId(userId);
        order.setAddress(address);
        order.setStatus("DRAFT");

        return orderRepository.saveOrder(order).get();
    }

    private void validate(DraftOrderCommand command) {
        if (command.getUserId() == null) {
            throw new CreateOrderException("User ID không được để trống");
        }
        if (command.getItems() == null || command.getItems().isEmpty()) {
            throw new CreateOrderException("Danh sách món ăn không được để trống");
        }
        for (DraftOrderCommand.OrderItem item : command.getItems()) {
            if (item.getFoodId() == null) {
                throw new CreateOrderException("Food ID trong đơn hàng không được để trống");
            }
        }
        // Các validate nghiệp vụ khác nếu cần
    }
}
