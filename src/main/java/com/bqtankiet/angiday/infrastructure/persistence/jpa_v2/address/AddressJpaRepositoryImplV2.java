package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressJpaRepositoryImplV2 implements IAddressRepository {

    private final AddressJpaRepositoryV2 addressJpaRepositoryV2;
    private final AddressJpaMapperV2 addressJpaMapperV2;

    @Autowired
    public AddressJpaRepositoryImplV2(AddressJpaRepositoryV2 addressJpaRepositoryV2, AddressJpaMapperV2 addressJpaMapperV2) {
        this.addressJpaRepositoryV2 = addressJpaRepositoryV2;
        this.addressJpaMapperV2 = addressJpaMapperV2;
    }


    @Override
    public Optional<Address> findById(Long id) {
        AddressJpaEntityV2 addressJpaEntityV2 = addressJpaRepositoryV2.findById(id).orElse(null);
        return Optional.ofNullable(addressJpaMapperV2.toDomain(addressJpaEntityV2));
    }

    @Override
    public List<Address> findAllByUserId(Long userId) {
        List<AddressJpaEntityV2> entities = addressJpaRepositoryV2.findAllByUserId(userId);
        return entities.stream().map(addressJpaMapperV2::toDomain).toList();
    }

    @Override
    public Optional<Address> getDefaultAddress(Long userId) {
        return null;
    }
}
