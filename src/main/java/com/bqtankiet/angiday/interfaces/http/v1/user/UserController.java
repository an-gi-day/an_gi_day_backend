package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.application.user.usecase.GetAllUser;
import com.bqtankiet.angiday.application.user.usecase.GetUserById;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bqtankiet
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final GetAllUser getAllUser;
    private final GetUserById getUserById;
    private final UserMapper userMapper;

    @Autowired
    public UserController(GetAllUser getAllUser, GetUserById getUserById, UserMapper userMapper) {
        this.getAllUser = getAllUser;
        this.getUserById = getUserById;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        var rs = getAllUser.call();
        var dto = rs.stream().map(userMapper::modelToDto).toList();
        ApiResponse<List<UserResponseDto>> apiResponse = ApiResponse.success(dto);
        apiResponse.addMetadata("size", dto.size());
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        var rs = getUserById.call(String.valueOf(id));
        var dto = userMapper.modelToDto(rs);
        ApiResponse<?> apiResponse = ApiResponse.success(dto);
        return ResponseEntity.ok(apiResponse);
    }
}