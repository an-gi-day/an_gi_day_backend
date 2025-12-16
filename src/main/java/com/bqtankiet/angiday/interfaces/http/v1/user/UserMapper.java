package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.application.user.dto.UserOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author bqtankiet
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "maskedEmail", target = "email")
    @Mapping(source = "maskedPhone", target = "phone")
    UserResponseDto modelToDto(UserOutput model);
}
