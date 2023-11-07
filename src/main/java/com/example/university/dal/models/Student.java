package com.example.university.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student extends User{
    private double yearResult;

    @ManyToOne
    private Section section;

    @ManyToMany
    private List<Course> courses;

    @OneToOne(mappedBy = "delegate")
    private Section delegateSection;
}
