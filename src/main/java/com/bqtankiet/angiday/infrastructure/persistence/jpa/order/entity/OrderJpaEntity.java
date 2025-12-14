package com.bqtankiet.angiday.infrastructure.persistence.jpa.order.entity;

import com.bqtankiet.angiday.infrastructure.persistence.jpa.address.AddressJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderJpaEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;  // theo định dạng OyyyyMMddHHmmss

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItemJpaEntity> items;

    @Embedded
    private OrderPricingJpaEmbed orderPricing;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentJpaEntity payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressJpaEntity address;

    private String voucherCode;

    private String status;

    private String userId;

    private Instant createdAt;

    public boolean addItem(OrderItemJpaEntity orderItemJpaEntity) {
        if (items == null) {
            items = new ArrayList<>();
        }
        orderItemJpaEntity.setOrder(this);
        orderItemJpaEntity.getOptions().forEach(option -> {
            option.setOrderItem(orderItemJpaEntity);});
        return items.add(orderItemJpaEntity);
    }
}
