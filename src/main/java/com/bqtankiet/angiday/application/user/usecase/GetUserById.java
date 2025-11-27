package com.bqtankiet.angiday.application.user.usecase;

import com.bqtankiet.angiday.application.base.DefaultUseCase;
import com.bqtankiet.angiday.application.user.dto.UserMapper;
import com.bqtankiet.angiday.application.user.dto.UserOutput;
import com.bqtankiet.angiday.domain.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bqtankiet
 */
@Service
public class GetUserById implements DefaultUseCase<String, UserOutput> {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public GetUserById(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserOutput call(String id) {
        var result = userRepository.findById(id);
        if (result.isPresent()) {
            return userMapper.toDto(result.get());
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }
}
