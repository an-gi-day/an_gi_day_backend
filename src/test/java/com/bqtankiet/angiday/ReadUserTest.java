package com.bqtankiet.angiday;

import com.bqtankiet.angiday.application.user.dto.UserOutputDTO;
import com.bqtankiet.angiday.application.user.usecase.ReadUser;
import com.bqtankiet.angiday.domain.user.model.User;
import com.bqtankiet.angiday.domain.user.repository.IUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadUserTest {

    @Test
    void shouldReturnAllUsers() {
        IUserRepository mockRepo = mock(IUserRepository.class);
        ReadUser readUser = new ReadUser(mockRepo);

        List<User> fakeUsers = List.of(new User(111L, "User1", "hashed-password", "user1@gmail.com", "0123456789"));

        when(mockRepo.findAll()).thenReturn(fakeUsers);

        List<UserOutputDTO> result = readUser.call();

        assertEquals(1, result.size());
        assertEquals("User1", result.get(0).getName());
    }
}
