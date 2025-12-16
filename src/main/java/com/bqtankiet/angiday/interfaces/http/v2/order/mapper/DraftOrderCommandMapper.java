package com.bqtankiet.angiday.interfaces.http.v2.order.mapper;

import com.bqtankiet.angiday.application.order.command.DraftOrderCommand;
import com.bqtankiet.angiday.application.user.usecase.GetCurrentUserId;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.CreateDraftOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class DraftOrderCommandMapper {

    private final GetCurrentUserId getCurrentUserId;

    public DraftOrderCommandMapper(GetCurrentUserId getCurrentUserId) {
        this.getCurrentUserId = getCurrentUserId;
    }

    public DraftOrderCommand fromRequest(CreateDraftOrderRequest request) {
        Long userId = getCurrentUserId.call();
        DraftOrderCommand draftOrderCommand = new DraftOrderCommand();
        draftOrderCommand.setUserId(userId);
        draftOrderCommand.setItems(
                request.items()
                        .stream()
                        .map(i -> new DraftOrderCommand.OrderItem(
                                i.foodId(), i.optionIds()
                        )).toList()
        );
        return draftOrderCommand;
    }

}
