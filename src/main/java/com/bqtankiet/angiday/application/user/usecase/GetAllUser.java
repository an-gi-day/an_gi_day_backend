package com.bqtankiet.angiday.application.user.usecase;

import com.bqtankiet.angiday.application.base.NoInputUseCase;
import com.bqtankiet.angiday.application.user.dto.UserMapper;
import com.bqtankiet.angiday.application.user.dto.UserOutput;
import com.bqtankiet.angiday.domain.user.IUserRepository;
import com.bqtankiet.angiday.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bqtankiet
 */
@Service
public class GetAllUser implements NoInputUseCase<List<UserOutput>> {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public GetAllUser(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserOutput> call() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDto).toList();
    }
}
