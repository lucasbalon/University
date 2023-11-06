package com.example.university.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;

@Entity
public class Professor extends User{
    private String office;
    @Temporal(value = TemporalType.DATE)
    private LocalDate hireDate;
    private double wage;

}
