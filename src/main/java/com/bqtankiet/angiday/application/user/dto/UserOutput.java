package com.bqtankiet.angiday.application.user.dto;

public record UserOutput(
        String id,
        String name,
        String maskedEmail,
        String maskedPhone
) {
}
