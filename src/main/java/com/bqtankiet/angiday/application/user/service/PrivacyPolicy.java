package com.bqtankiet.angiday.application.user.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PrivacyPolicy {

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            return "*****";
        }
        int atIndex = email.indexOf("@");
        String prefix = email.substring(0, Math.min(2, atIndex));
        return prefix + "*****" + email.substring(atIndex);
    }

    public static String maskPhone(String phone) {
        if (phone == null || phone.length() < 6) {
            return "*****";
        }
        String masked = phone.substring(0, 3) + "*****" + phone.substring(phone.length() - 3);
        return masked;
    }


}
