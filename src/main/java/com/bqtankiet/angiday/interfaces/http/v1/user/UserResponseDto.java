package com.bqtankiet.angiday.interfaces.http.v1.user;

public record UserResponseDto(
        String id,
        String name,
        String email,
        String phone
) {

}