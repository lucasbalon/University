package com.example.university.pl.models;

import com.example.university.dal.models.Professor;
import lombok.Data;

@Data
public class CourseForm {
    private String courseName;

    private int courseEcts;

    private Professor professor;
}
