package com.bqtankiet.angiday.infrastructure.persistence.user;

import com.bqtankiet.angiday.domain.user.model.User;
import com.bqtankiet.angiday.domain.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bqtankiet.angiday.infrastructure.persistence.user.UserMapper.domainToEntity;
import static com.bqtankiet.angiday.infrastructure.persistence.user.UserMapper.entityToDomain;

@Service
public class UserRepositoryImpl implements IUserRepository {
    private final UserRepositoryJpa userRepositoryJpa;

    @Autowired
    public UserRepositoryImpl(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryJpa.findById(id).map(UserMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepositoryJpa.findByName(name).map(UserMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryJpa.findByEmail(email).map(UserMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByPhone(String phone) {
        return userRepositoryJpa.findByPhone(phone).map(UserMapper::entityToDomain);
    }

    @Override
    public Optional<User> save(User user) {
        if (user == null) {
            // TODO: handle null here
        } else {

        }
        return Optional.empty(); // ????
    }

    @Override
    public List<User> findAll() {
        return userRepositoryJpa.findAll()
                .stream()
                .map(UserMapper::entityToDomain)
                .collect(Collectors.toList());
    }

}
