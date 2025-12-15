package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base;

public interface JpaMapper<M, D> {

    M dtoToModel(D dto);
    D modelToDto(M model);

}
