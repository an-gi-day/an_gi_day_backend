package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressJpaMapper extends JpaMapper<Address, AddressJpaEntityV2> {
}
