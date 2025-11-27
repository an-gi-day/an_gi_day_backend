package com.bqtankiet.angiday.application.user.dto;

import com.bqtankiet.angiday.application.base.DataMapper;
import com.bqtankiet.angiday.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DataMapper<User, UserOutput> {

    @Override
    public UserOutput toDto(User user) {
        return new UserOutput(
                String.valueOf(user.getId()),
                user.getName(),
                user.getMaskedEmail(),
                user.getMaskedPhone());
    }

    @Override
    public User toModel(UserOutput userOutput) {
        return null;
    }
}
