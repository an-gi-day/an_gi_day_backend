package com.bqtankiet.angiday.domain.address;

import java.util.Optional;

public interface IAddressRepository {

    public Optional<Address> findById(String id);

}
