package com.bqtankiet.angiday.infrastructure.persistence.jpa.brand;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BrandRepositoryImpl implements IBrandRepository {

    private final BrandJpaRepository brandJpaRepository;
    private final BrandJpaMapper brandJpaMapper;

    @Autowired
    public BrandRepositoryImpl(BrandJpaRepository brandJpaRepository, BrandJpaMapper brandJpaMapper) {
        this.brandJpaRepository = brandJpaRepository;
        this.brandJpaMapper = brandJpaMapper;
    }

    @Override
    public List<Brand> findAll() {
        List<BrandJpaEntity> rs = brandJpaRepository.findAll();
        return rs.stream()
                .map(brandJpaMapper::dtoToModel)
                .toList();
    }

    @Override
    public Optional<Brand> findById(String id) {
        return brandJpaRepository
                .findById(Long.parseLong(id))
                .map(brandJpaMapper::dtoToModel);
    }
}
