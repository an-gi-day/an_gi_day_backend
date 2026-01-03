package com.bqtankiet.angiday.interfaces.http.v1.brand;

import com.bqtankiet.angiday.domain.DomainDtoMapper;
import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface BrandResponseMapper extends DomainDtoMapper<Brand, BrandResponseDto> {
}
