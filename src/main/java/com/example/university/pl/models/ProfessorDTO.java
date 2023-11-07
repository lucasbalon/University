package com.example.university.pl.models;

import com.example.university.dal.models.Course;
import com.example.university.dal.models.Professor;
import com.example.university.dal.models.Section;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ProfessorDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;
    private String login;
    private String password;
    private boolean enabled;

    private String office;
    private LocalDate hireDate;
    private double wage;
    private List<Course> courses;
    private Section section;

    public static ProfessorDTO fromEntity(Professor professor) {
        return ProfessorDTO.builder()
                .id(professor.getId())
                .name(professor.getName())
                .surname(professor.getSurname())
                .birthDate(professor.getBirthDate())
                .email(professor.getEmail())
                .login(professor.getLogin())
                .password(professor.getPassword())
                .enabled(professor.isEnabled())
                .office(professor.getOffice())
                .hireDate(professor.getHireDate())
                .wage(professor.getWage())
                .courses(professor.getCourses())
                .section(professor.getSection())
                .build();
    }
}
