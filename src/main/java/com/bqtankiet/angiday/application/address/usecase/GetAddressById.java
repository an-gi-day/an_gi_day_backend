package com.bqtankiet.angiday.application.address.usecase;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GetAddressById {

    private final IAddressRepository addressRepository;

    @Autowired
    public GetAddressById(
            @Qualifier("AddressRepositoryImpl")
            IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address call(Long id) {
        return addressRepository.findById(id).orElse(null);
    }
}
