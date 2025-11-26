package com.bqtankiet.angiday.infrastructure.persistence.user;

import com.bqtankiet.angiday.domain.user.model.User;

public class UserMapper {

    public static User entityToDomain(UserEntity user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getHashedPassword(),
                user.getEmail(),
                user.getPhone());
    }

    public static UserEntity domainToEntity(User user) {
        return null;
    }

}
