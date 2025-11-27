package com.bqtankiet.angiday.application.base;

public interface DataMapper<SOURCE, TARGET> {
    TARGET toDto(SOURCE source);
    SOURCE toModel(TARGET target);
}