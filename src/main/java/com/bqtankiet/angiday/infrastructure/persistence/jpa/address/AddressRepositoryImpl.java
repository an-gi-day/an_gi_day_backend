package com.bqtankiet.angiday.infrastructure.persistence.jpa.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("AddressRepositoryImpl")
public class AddressRepositoryImpl implements IAddressRepository {

    private final AddressJpaRepository addressJpaRepository;
    private final AddressJpaMapper addressJpaMapper;

    @Autowired
    public AddressRepositoryImpl(AddressJpaRepository addressJpaRepository, AddressJpaMapper addressJpaMapper) {
        this.addressJpaRepository = addressJpaRepository;
        this.addressJpaMapper = addressJpaMapper;
    }


    @Override
    public Optional<Address> findById(Long id) {
        AddressJpaEntity addressJpaEntity = addressJpaRepository.findById(Long.valueOf(id)).orElse(null);
        return Optional.ofNullable(addressJpaMapper.toDomain(addressJpaEntity));
    }

    @Override
    public List<Address> findAllByUserId(Long userId) {
        List<AddressJpaEntity> entities = addressJpaRepository.findAllByUserId(userId);
        return entities.stream().map(addressJpaMapper::toDomain).toList();
    }

    @Override
    public Optional<Address> getDefaultAddress(Long userId) {
        Optional<AddressJpaEntity> entity = addressJpaRepository.findFirstByUserIdAndIsDefault(userId, true);
        return entity.map(addressJpaMapper::toDomain);
    }
}
