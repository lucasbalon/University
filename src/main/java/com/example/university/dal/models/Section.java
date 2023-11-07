package com.example.university.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionName;

    @OneToMany(mappedBy = "section")
    private List<Professor> professor;

    @OneToMany(mappedBy = "section")
    private List<Student> students;

    @OneToOne
    private Student delegate;
}
