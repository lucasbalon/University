package com.example.university.pl.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginForm {
    private String login;
    private String password;
}
