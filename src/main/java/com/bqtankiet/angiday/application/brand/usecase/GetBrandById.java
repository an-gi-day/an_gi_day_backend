package com.bqtankiet.angiday.application.brand.usecase;

import com.bqtankiet.angiday.application.base.UseCase;
import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.brand.IBrandRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetBrandById implements UseCase<GetBrandById.Input, GetBrandById.Output> {

    private final IBrandRepository brandRepository;

    private String id;

    @Autowired
    public GetBrandById(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Output call() {
        var rs = brandRepository.findById(id);
        if (rs.isPresent()) {
            return new Output(rs.get());
        }
        throw new EntityNotFoundException("Brand not found");
    }

    @Override
    public GetBrandById with(Input input) {
        id =  input.id;
        return this;
    }

    public GetBrandById withId(String id) {
        this.id = id;
        return this;
    }
    public record Input(String id) implements InputModel {}
    public record Output(Brand brand) implements OutputModel {}
}
