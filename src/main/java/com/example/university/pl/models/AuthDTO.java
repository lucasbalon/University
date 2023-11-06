package com.example.university.pl.models;

import com.example.university.dal.models.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AuthDTO {
    private String login;
    private String token;
    private Set<UserRole> roles;
}
