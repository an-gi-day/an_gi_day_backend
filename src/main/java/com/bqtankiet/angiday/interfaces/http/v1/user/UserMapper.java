package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends JpaMapper<User, UserResponseDto> {
}
