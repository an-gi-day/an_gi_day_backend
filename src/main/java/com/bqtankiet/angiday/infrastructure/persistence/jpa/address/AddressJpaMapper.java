package com.bqtankiet.angiday.infrastructure.persistence.jpa.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressJpaMapper extends DomainEntityMapper<Address, AddressJpaEntity> {
}
