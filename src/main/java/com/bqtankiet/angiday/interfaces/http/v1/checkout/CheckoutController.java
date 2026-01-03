package com.bqtankiet.angiday.interfaces.http.v1.checkout;

import com.bqtankiet.angiday.application.order.exception.CreateOrderException;
import com.bqtankiet.angiday.application.order.usecase.CreateOrderUseCase;
import com.bqtankiet.angiday.application.temp.GetAddressOptionsUseCase;
import com.bqtankiet.angiday.application.temp.GetPaymentOptionsUseCase;
import com.bqtankiet.angiday.application.user.usecase.GetCurrentUserId;
import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.domain.payment.Payment;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import com.bqtankiet.angiday.interfaces.http.v1.checkout.dto.CheckoutRequest;
import com.bqtankiet.angiday.interfaces.http.v1.checkout.mapper.CreateOrderResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController()
@RequestMapping("/api/v1/orders/checkout")
public class CheckoutController {

    private final GetCurrentUserId getCurrentUserId;
    private final CreateOrderUseCase createOrderUseCase;
    private final CreateOrderResponseMapper createOrderResponseMapper;
    private final GetPaymentOptionsUseCase getPaymentOptionsUseCase;
    private final GetAddressOptionsUseCase getAddressOptionsUseCase;

    @Autowired
    public CheckoutController(GetCurrentUserId getCurrentUserId, CreateOrderUseCase createOrderUseCase, CreateOrderResponseMapper createOrderResponseMapper, GetPaymentOptionsUseCase getPaymentOptionsUseCase, GetAddressOptionsUseCase getAddressOptionsUseCase) {
        this.getCurrentUserId = getCurrentUserId;
        this.createOrderUseCase = createOrderUseCase;
        this.createOrderResponseMapper = createOrderResponseMapper;
        this.getPaymentOptionsUseCase = getPaymentOptionsUseCase;
        this.getAddressOptionsUseCase = getAddressOptionsUseCase;
    }

    /**
     * Chỉ tạo thông tin order và response về client. Chưa tạo và lưu order trong database
     */
    @PostMapping()
    public ResponseEntity<?> draftOrder(@RequestBody CheckoutRequest request) {
        Long userId = getCurrentUserId.call();
        // FAILED:
        // TODO: Kiểm tra đầu vào

        // SUCCESS
        Order order = createOrderUseCase.createDraft(userId, request);
        var respDto = createOrderResponseMapper.toResponse(order);
        var apiResponse = ApiResponse.success(respDto);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    public ResponseEntity<?> getDraftOrder() {
        Long userId = getCurrentUserId.call();

        try {
            Order order = createOrderUseCase.getDraftOrder(userId);
            var respDto = createOrderResponseMapper.toResponse(order);

            var apiResponse = ApiResponse.success(respDto);
            apiResponse.addMetadata("currentState", "AWAITING_FOR_CONFIRM");
            var paymentOptions = getPaymentOptionsUseCase.call();
            apiResponse.addMetadata("paymentOptions", paymentOptions);
            var addressOptions = getAddressOptionsUseCase.call(userId);
            apiResponse.addMetadata("addressOptions", addressOptions);
//        TODO: var voucherOptions = getVoucherOptionsUseCase.call(userId, order);
            apiResponse.addMetadata("voucherOptions", Collections.emptyList());

            return ResponseEntity.ok(apiResponse);
        } catch (CreateOrderException e) {
            return ResponseEntity.status(400).body(ApiResponse.error(400, e.getMessage()));
        }
    }

    @PostMapping("/payment-method")
    public ResponseEntity<?> updatePaymentMethod(@RequestBody Map<String, String> request) {
        Long userId = getCurrentUserId.call();
        String paymentMethod = request.get("paymentMethod");
        try {
            Payment payment = createOrderUseCase.updatePayment(userId, paymentMethod);
            return ResponseEntity.ok().body(ApiResponse.success(payment));
        } catch (CreateOrderException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmOrder() {
        Long userId = getCurrentUserId.call();
        try {
            Order order = createOrderUseCase.confirmOrder(userId);
            var respDto = createOrderResponseMapper.toResponse(order);
            return ResponseEntity.ok().body(ApiResponse.success(respDto));
        } catch (CreateOrderException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }

    @PostMapping("/address")
    public ResponseEntity<?> updateAddress(@RequestBody Map<String, String> request) {
        Long userId = getCurrentUserId.call();
        String addressId = request.get("addressId");
        try {
            Address address = createOrderUseCase.updateAddress(userId, Long.parseLong(addressId));
            return ResponseEntity.ok().body(ApiResponse.success(address));
        } catch (CreateOrderException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }
}
