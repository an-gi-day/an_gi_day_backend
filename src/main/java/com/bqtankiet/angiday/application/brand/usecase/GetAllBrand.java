package com.bqtankiet.angiday.application.brand.usecase;

import com.bqtankiet.angiday.application.base.DefaultUseCase.OutputModel;
import com.bqtankiet.angiday.application.base.NoInputUseCase;
import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bqtankiet
 */
@Service
public class GetAllBrand implements NoInputUseCase<GetAllBrand.Output> {

    private final IBrandRepository brandRepository;

    @Autowired
    public GetAllBrand(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Output call() {
        return new Output(brandRepository.findAll());
    }

    public record Output(List<Brand> brands) implements OutputModel {}
}
