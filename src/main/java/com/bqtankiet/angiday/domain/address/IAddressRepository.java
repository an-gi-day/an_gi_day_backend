package com.bqtankiet.angiday.domain.address;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository {

    public Optional<Address> findById(String id);

    List<Address> findAllByUserId(String userId);
}
