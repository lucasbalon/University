package com.example.university.bll;

import com.example.university.dal.models.User;
import com.example.university.pl.models.AuthDTO;
import com.example.university.pl.models.LoginForm;
import com.example.university.pl.models.UserForm;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    void register(UserForm form);
    AuthDTO login(LoginForm form);
    Optional<User> getOne(String login);
    Set<String> getAllName();
}
