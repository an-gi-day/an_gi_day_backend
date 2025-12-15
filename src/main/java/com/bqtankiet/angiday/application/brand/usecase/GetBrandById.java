package com.bqtankiet.angiday.application.brand.usecase;

import com.bqtankiet.angiday.application.base.DefaultUseCase;
import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author bqtankiet
 */
@Service
public class GetBrandById implements DefaultUseCase<Long, Brand> {

    private final IBrandRepository brandRepository;

    @Autowired
    public GetBrandById(
            @Qualifier("BrandRepositoryImpl")
            IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand call(Long id) {
        var rs = brandRepository.findById(id);
        if (rs.isPresent()) {
            return rs.get();
        }
        throw new EntityNotFoundException("Brand not found");
    }
}
