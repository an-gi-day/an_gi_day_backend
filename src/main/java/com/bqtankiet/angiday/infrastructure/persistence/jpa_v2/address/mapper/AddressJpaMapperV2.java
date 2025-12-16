package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address.mapper;

import com.bqtankiet.angiday.domain.address.Address;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.JpaMapperV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.address.entity.AddressJpaEntityV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressJpaMapperV2 extends JpaMapperV2<Address, AddressJpaEntityV2> {
}
