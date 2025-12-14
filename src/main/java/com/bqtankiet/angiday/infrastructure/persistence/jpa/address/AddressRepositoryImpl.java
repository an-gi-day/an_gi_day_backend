package com.bqtankiet.angiday.infrastructure.persistence.jpa.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.repository.FoodJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AddressRepositoryImpl implements IAddressRepository {

    private final AddressJpaRepository addressJpaRepository;
    private final AddressJpaMapper addressJpaMapper;

    @Autowired
    public AddressRepositoryImpl(AddressJpaRepository addressJpaRepository, AddressJpaMapper addressJpaMapper) {
        this.addressJpaRepository = addressJpaRepository;
        this.addressJpaMapper = addressJpaMapper;
    }


    @Override
    public Optional<Address> findById(String id) {
        AddressJpaEntity addressJpaEntity = addressJpaRepository.findById(Long.valueOf(id)).orElse(null);
        return Optional.of(addressJpaMapper.dtoToModel(addressJpaEntity));
    }
}
