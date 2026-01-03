package com.bqtankiet.angiday.domain.address;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository {

    Optional<Address> findById(Long id);

    List<Address> findAllByUserId(Long userId);

    Optional<Address> getDefaultAddress(Long userId);
}
