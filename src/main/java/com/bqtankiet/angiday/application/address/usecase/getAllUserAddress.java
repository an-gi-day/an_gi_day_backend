package com.bqtankiet.angiday.application.address.usecase;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getAllUserAddress {
    private final IAddressRepository addressRepository;

    @Autowired
    public getAllUserAddress(
            @Qualifier("AddressRepositoryImpl")
            IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> execute(String userId){
        return addressRepository.findAllByUserId(userId);
    }

}
