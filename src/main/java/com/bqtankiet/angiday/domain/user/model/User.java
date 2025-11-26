package com.bqtankiet.angiday.domain.user.model;

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String hashedPassword;
    private String email;
    private String phone;

    public User() {
    }

    public User(Long id, String name, String hashedPassword, String email, String phone) {
        this.id = id;
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.email = email;
        this.phone = phone;
    }

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            return "*****";
        }
        int atIndex = email.indexOf("@");
        String prefix = email.substring(0, Math.min(2, atIndex));
        String suffix = email.substring(atIndex);
        return prefix + "*****" + suffix;
    }

    public static String maskPhone(String phone) {
        if (phone == null || phone.length() < 6) {
            return "*****";
        }
        String prefix = phone.substring(0, 3);
        String suffix = phone.substring(phone.length() - 3);
        return prefix + "*****" + suffix;
    }

    public String getMaskedEmail() {
        return maskEmail(email);
    }

    public String getMaskedPhone() {
        return maskPhone(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(hashedPassword, user.hashedPassword) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hashedPassword, email, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}