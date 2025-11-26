package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.application.user.usecase.GetAllUser;
import com.bqtankiet.angiday.domain.user.model.User;
import com.bqtankiet.angiday.interfaces.http.base.DataMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements DataMapper<User, UserResponseDto> {
    @Override
    public UserResponseDto modelToDto(User user) {
        return new UserResponseDto(
                String.valueOf(user.getId()),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }

    @Override
    public User dtoToModel(UserResponseDto y) {
        return null;
    }

    public List<UserResponseDto> toDtoList(GetAllUser.Output model){
        return model.users().stream().map(this::modelToDto).collect(Collectors.toList());
    }
}
