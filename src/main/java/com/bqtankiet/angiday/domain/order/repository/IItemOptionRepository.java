package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.ItemOption;

import java.util.Optional;

public interface IItemOptionRepository {

    Optional<ItemOption> findById(String id);
    Optional<ItemOption> createItemOption(ItemOption option);
    Optional<ItemOption> updateItemOption(ItemOption option);

}
