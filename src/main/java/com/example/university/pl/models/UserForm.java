package com.example.university.pl.models;

import com.example.university.dal.models.UserRole;
import lombok.Data;

import java.util.Set;

@Data
public class UserForm {
    private String name;

    private Set<UserRole> roles;

    private String login;
    private String password;
}
