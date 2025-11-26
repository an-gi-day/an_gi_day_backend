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
import java.util.Map;

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
        GetAllUser.Output output = getAllUser
                .with(GetAllUser.MaskFlag.MASK_EMAIL_PHONE)
                .call();
        List<UserResponseDto> dtoList = userMapper.toDtoList(output);
        ApiResponse<List<UserResponseDto>> apiResponse = ApiResponse.success(dtoList);
        apiResponse.setMetadata(Map.of("size", dtoList.size()));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        GetUserById.Output out = getUserById
                .withId(id)
                .call();
        UserResponseDto dto = userMapper.modelToDto(out.user());
        ApiResponse<?> apiResponse = ApiResponse.success(dto);
        return ResponseEntity.ok(apiResponse);
    }
}