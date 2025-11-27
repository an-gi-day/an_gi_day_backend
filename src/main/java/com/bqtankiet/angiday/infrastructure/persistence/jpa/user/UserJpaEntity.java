package com.bqtankiet.angiday.infrastructure.persistence.jpa.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bqtankiet
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String hashedPassword;

}