package com.example.university.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Professor extends User{
    private String office;
    @Temporal(value = TemporalType.DATE)
    private LocalDate hireDate;
    private double wage;
    @OneToMany(mappedBy = "professor")
    private List<Course> courses;

    @ManyToOne
    private Section section;

}
