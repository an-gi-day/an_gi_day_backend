package com.bqtankiet.angiday.infrastructure.persistence.jpa.brand;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandJpaMapper extends JpaMapper<Brand, BrandJpaEntity> {
}
