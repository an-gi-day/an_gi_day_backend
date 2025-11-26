package com.bqtankiet.angiday.interfaces.http.base;

/**
 *
 * @param <M> ModelClass
 * @param <D> DtoClass
 */
public interface DataMapper<M, D> {

    D modelToDto(M m);

    M dtoToModel(D y);

}
