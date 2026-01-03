package com.bqtankiet.angiday.infrastructure.persistence.jpa.address;

import com.bqtankiet.angiday.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressJpaRepository extends JpaRepository<AddressJpaEntity,Long> {
    List<AddressJpaEntity> findAllByUserId(Long userId);

    Optional<AddressJpaEntity> findFirstByUserIdAndIsDefault(Long userId, Boolean isDefault);
}
