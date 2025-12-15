package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        AddressJpaEntityV2 addressJpaEntityV2 = addressJpaRepository.findById(Long.valueOf(id)).orElse(null);
        return Optional.ofNullable(addressJpaMapper.dtoToModel(addressJpaEntityV2));
    }

    @Override
    public List<Address> findAllByUserId(String userId) {
        List<AddressJpaEntityV2> entities = addressJpaRepository.findAllByUserId(userId);
        return entities.stream().map(addressJpaMapper::dtoToModel).toList();
    }
}
