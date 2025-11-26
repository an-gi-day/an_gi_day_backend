package com.bqtankiet.angiday.application.user.usecase;

import com.bqtankiet.angiday.application.user.dto.UserOutputDTO;
import com.bqtankiet.angiday.application.user.service.UserMapper;
import com.bqtankiet.angiday.domain.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadUser  {

    private final IUserRepository userRepository;

    @Autowired
    public ReadUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserOutputDTO> call() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }
}
