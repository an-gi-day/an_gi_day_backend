package com.bqtankiet.angiday.infrastructure.persistence.jpa.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressJpaRepository extends JpaRepository<AddressJpaEntity,Long> {
    List<AddressJpaEntity> findAllByUserId(String userId);
}
