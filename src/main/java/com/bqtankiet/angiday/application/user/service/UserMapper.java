package com.bqtankiet.angiday.application.user.service;

import com.bqtankiet.angiday.application.user.dto.UserOutputDTO;
import com.bqtankiet.angiday.domain.user.model.User;

public class UserMapper {

    public static UserOutputDTO toDto(User model) {
        UserOutputDTO dto = new UserOutputDTO();
        dto.id = String.valueOf(model.getId());
        dto.name = model.getName();
        dto.email = PrivacyPolicy.maskEmail(model.getEmail());
        dto.phone = PrivacyPolicy.maskPhone(model.getPhone());
        return dto;
    }

}
