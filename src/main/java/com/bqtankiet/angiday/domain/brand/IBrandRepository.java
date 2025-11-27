package com.bqtankiet.angiday.domain.brand;

import java.util.List;
import java.util.Optional;

public interface IBrandRepository {

    List<Brand> findAll();

    Optional<Brand> findById(String id);
}
