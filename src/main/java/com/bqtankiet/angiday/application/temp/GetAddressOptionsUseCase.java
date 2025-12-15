package com.bqtankiet.angiday.application.temp;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAddressOptionsUseCase {

    private final IAddressRepository addressRepository;

    @Autowired
    public GetAddressOptionsUseCase(
            @Qualifier("AddressRepositoryImpl")
            IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> call(String userId){
        return addressRepository.findAllByUserId(Long.parseLong(userId));
    }

}
