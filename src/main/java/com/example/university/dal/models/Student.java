package com.example.university.dal.models;

import jakarta.persistence.Entity;

@Entity
public class Student extends User{
    private double yearResult;
}
