package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.application.user.dto.UserOutputDTO;
import com.bqtankiet.angiday.application.user.usecase.ReadUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {

    @Autowired
    private ReadUser readUser;

    @GetMapping
    public ResponseEntity<UserResponseDTO> getAllUsers() {
        List<UserOutputDTO> user = readUser.call();
        return ResponseEntity.ok(UserResponseDTO.success(user));
    }
}