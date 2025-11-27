package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.application.user.dto.UserOutput;
import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.base.JpaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends JpaMapper<UserOutput, UserResponseDto> {

    @Override
    @Mapping(source = "maskedEmail", target = "email")
    @Mapping(source = "maskedPhone", target = "phone")
    UserResponseDto modelToDto(UserOutput model);
}
