package com.bqtankiet.angiday.infrastructure.persistence.jpa.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper(componentModel = "spring")
public interface AddressJpaMapper extends JpaMapper<Address, AddressJpaEntity> {
}
