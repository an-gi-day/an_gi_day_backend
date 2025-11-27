package com.bqtankiet.angiday.infrastructure.persistence.jpa.user;

import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.domain.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author bqtankiet
 */
@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final UserJpaRepository userRepositoryJpa;
    private final UserJpaMapper userJpaMapper;

    @Autowired
    public UserRepositoryImpl(UserJpaRepository userRepositoryJpa, UserJpaMapper userJpaMapper) {
        this.userRepositoryJpa = userRepositoryJpa;
        this.userJpaMapper = userJpaMapper;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryJpa.findById(id).map(userJpaMapper::dtoToModel);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepositoryJpa.findByName(name).map(userJpaMapper::dtoToModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryJpa.findByEmail(email).map(userJpaMapper::dtoToModel);
    }

    @Override
    public Optional<User> findByPhone(String phone) {
        return userRepositoryJpa.findByPhone(phone).map(userJpaMapper::dtoToModel);
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
                .map(userJpaMapper::dtoToModel)
                .collect(Collectors.toList());
    }

}
