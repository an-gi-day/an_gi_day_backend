package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.base;

public interface JpaMapperV2<D, E> {

    D toDomain(E entity);

    E toEntity(D domain);

}
