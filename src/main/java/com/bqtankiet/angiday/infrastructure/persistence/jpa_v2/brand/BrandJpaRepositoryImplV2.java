package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.brand;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
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
