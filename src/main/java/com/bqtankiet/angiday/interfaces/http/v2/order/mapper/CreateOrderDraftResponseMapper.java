package com.bqtankiet.angiday.interfaces.http.v2.order.mapper;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.order.models.Order;
import com.bqtankiet.angiday.interfaces.http.v2.order.dto.CreateOrderDraftResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDraftResponseMapper implements DomainDtoMapper<Order, CreateOrderDraftResponse> {
    @Override
    public CreateOrderDraftResponse toDto(Order order) {
        var dto = new CreateOrderDraftResponse();
        dto.setId(order.getId());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setStatus(order.getStatus());
        return dto;
    }

    @Override
    public Order toDomain(CreateOrderDraftResponse domain) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
