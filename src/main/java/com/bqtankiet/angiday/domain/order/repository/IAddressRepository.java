package com.bqtankiet.angiday.domain.order.repository;

import com.bqtankiet.angiday.domain.order.models.Address;

import java.util.Optional;

public interface IAddressRepository {

    Optional<Address> findById(String id);
    Optional<Address> createAddress(Address address);
    Optional<Address> updateAddress(Address address);

}
