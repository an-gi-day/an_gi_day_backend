package com.bqtankiet.angiday.infrastructure.persistence.jpa.user;

import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.domain.DomainEntityMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface UserJpaMapper extends DomainEntityMapper<User, UserJpaEntity> {
}