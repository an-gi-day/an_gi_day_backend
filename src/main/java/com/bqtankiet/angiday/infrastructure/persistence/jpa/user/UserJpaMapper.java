package com.bqtankiet.angiday.infrastructure.persistence.jpa.user;

import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserJpaMapper extends JpaMapper<User, UserJpaEntity> {
}