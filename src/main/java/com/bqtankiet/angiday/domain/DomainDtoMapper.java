package com.bqtankiet.angiday.domain;

public interface DomainDtoMapper <DOMAIN, DTO>{
    DTO toDto(DOMAIN domain);
    DOMAIN toDomain(DTO domain);
}
