package com.bqtankiet.angiday.interfaces.http.v2.payment.controller;

import com.bqtankiet.angiday.application.order.usecase.GetOrderByCodeUseCase;
import com.bqtankiet.angiday.application.order.usecase.SaveOrderUseCase;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.v2.payment.dto.MoMoIpnRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MoMoIpnController.ENDPOINT)
@Slf4j
@RequiredArgsConstructor
public class MoMoIpnController {
    public static final String ENDPOINT = "/api/v1/momo-ipn";
    private final SaveOrderUseCase saveOrderUseCase;
    private final GetOrderByCodeUseCase getOrderByCode;

    //https://developers.momo.vn/v3/docs/payment/api/result-handling/notification/#processing-payment-result
    @PostMapping()
    public ResponseEntity<Void> processPayment(@RequestBody(required = false) MoMoIpnRequest moMoIpnRequest) {
        log.error("MOMO IPN Request received");
        if(moMoIpnRequest!= null && moMoIpnRequest.getResultCode() == 0){
            String orderCode = moMoIpnRequest.getOrderId();
            Order order = getOrderByCode.execute(orderCode);
            order.getPayment().setPaymentStatus("PAID");
            Order updateOrder = saveOrderUseCase.call(order);
            if(!updateOrder.isPaid()){
                // something error
            }
        }
        return ResponseEntity.status(204).build();
    }
}
