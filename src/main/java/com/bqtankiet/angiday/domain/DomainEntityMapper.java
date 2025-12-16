package com.bqtankiet.angiday.domain;

public interface DomainEntityMapper <DOMAIN, ENTITY> {
    ENTITY toEntity(DOMAIN domain);
    DOMAIN toDomain(ENTITY entity);
}
