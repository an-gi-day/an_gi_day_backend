package com.bqtankiet.angiday.application.brand.usecase;

import com.bqtankiet.angiday.application.base.UseCase;
import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllBrand implements UseCase<GetAllBrand.Input, GetAllBrand.Output> {

    private final IBrandRepository brandRepository;

    @Autowired
    public GetAllBrand(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Output call() {
        return new Output(brandRepository.findAll());
    }

    @Override
    public GetAllBrand with(Input input) {
        return this;
    }



    public record Input() implements InputModel {}
    public record Output(List<Brand> brands) implements OutputModel {}
}
