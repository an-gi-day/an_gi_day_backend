package com.bqtankiet.angiday.domain.user;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    Optional<User> save(User user);
    List<User> findAll();
}
