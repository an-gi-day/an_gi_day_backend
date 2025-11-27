package com.bqtankiet.angiday.domain.user;

import java.util.List;
import java.util.Optional;

/**
 * @author bqtankiet
 */
public interface IUserRepository {

    Optional<User> findById(String id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    Optional<User> save(User user);
    List<User> findAll();
}
