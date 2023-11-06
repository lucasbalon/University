package com.example.university.pl.controller;

import com.example.university.bll.UserService;
import com.example.university.pl.models.AuthDTO;
import com.example.university.pl.models.LoginForm;
import com.example.university.pl.models.UserDTO;
import com.example.university.pl.models.UserForm;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form){
        return userService.login(form);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public void register(@RequestBody UserForm form){
        userService.register(form);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/one")
    public UserDTO getOne(Authentication authentication){
        return UserDTO.fromEntity(userService.getOne(authentication.getName()).orElseThrow(()-> new RuntimeException("Pas trouvé")));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public Set<String> getAllNames(){
        return userService.getAllName();
    }
}
