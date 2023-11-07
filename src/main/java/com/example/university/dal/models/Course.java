package com.example.university.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {

    @Id
    private String courseId;

    private String courseName;

    private int courseEcts;

    @ManyToOne
    private Professor professor;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
