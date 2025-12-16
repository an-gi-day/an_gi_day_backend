package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.repository;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.entity.BrandJpaEntityV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand.mapper.BrandJpaMapperV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author bqtankiet
 */
@Repository
public class BrandJpaRepositoryImplV2 implements IBrandRepository {

    private final BrandJpaRepositoryV2 brandJpaRepository;
    private final BrandJpaMapperV2 brandJpaMapper;

    @Autowired
    public BrandJpaRepositoryImplV2(BrandJpaRepositoryV2 brandJpaRepository, BrandJpaMapperV2 brandJpaMapper) {
        this.brandJpaRepository = brandJpaRepository;
        this.brandJpaMapper = brandJpaMapper;
    }

    @Override
    public List<Brand> findAll() {
        List<BrandJpaEntityV2> rs = brandJpaRepository.findAll();
        return rs.stream()
                .map(brandJpaMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandJpaRepository
                .findById(id)
                .map(brandJpaMapper::toDomain);
    }
}
