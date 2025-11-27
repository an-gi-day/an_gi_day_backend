package com.bqtankiet.angiday.infrastructure.persistence.jpa.base;

public interface JpaMapper<M, D> {

    M dtoToModel(D dto);
    D modelToDto(M model);

}
