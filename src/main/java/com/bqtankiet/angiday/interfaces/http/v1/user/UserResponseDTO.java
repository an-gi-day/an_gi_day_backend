package com.bqtankiet.angiday.interfaces.http.v1.user;

import com.bqtankiet.angiday.application.user.dto.UserOutputDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDTO {
    private int size;
    private int code;
    private String status;
    private List<UserOutputDTO> data;

    public static UserResponseDTO success(List<UserOutputDTO> users) {
        return new UserResponseDTO(
                users.size(),
                200,
                "success",
                users
        );
    }
}