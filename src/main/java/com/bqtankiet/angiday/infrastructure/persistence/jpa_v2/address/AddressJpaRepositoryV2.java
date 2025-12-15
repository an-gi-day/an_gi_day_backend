package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressJpaRepository extends JpaRepository<AddressJpaEntityV2,Long> {
    List<AddressJpaEntityV2> findAllByUserId(String userId);
}
