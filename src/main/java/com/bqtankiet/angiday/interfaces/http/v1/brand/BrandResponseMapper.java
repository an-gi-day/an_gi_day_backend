package com.bqtankiet.angiday.interfaces.http.v1.brand;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandResponseMapper extends JpaMapper<Brand, BrandResponseDto> {
}
