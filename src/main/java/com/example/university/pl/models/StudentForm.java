package com.example.university.pl.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentForm {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;
    private String login;
    private String password;
}
