package com.bqtankiet.angiday.infrastructure.persistence.jpa.brand;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface BrandJpaMapper extends DomainEntityMapper<Brand, BrandJpaEntity> {
}
