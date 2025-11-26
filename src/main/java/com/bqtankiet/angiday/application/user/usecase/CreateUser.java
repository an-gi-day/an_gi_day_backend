package com.bqtankiet.angiday.application.user.usecase;

import com.bqtankiet.angiday.domain.user.model.User;
import com.bqtankiet.angiday.domain.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser{

    private final IUserRepository repository;

    @Autowired
    public CreateUser(IUserRepository repository) {
        this.repository = repository;
    }

    public User call(User user) {
        return repository.save(user);
    }
}
