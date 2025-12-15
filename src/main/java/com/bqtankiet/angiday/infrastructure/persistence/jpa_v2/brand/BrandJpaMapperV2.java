package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base.JpaMapperV2;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface BrandJpaMapperV2 extends JpaMapperV2<Brand, BrandJpaEntityV2> {
}
