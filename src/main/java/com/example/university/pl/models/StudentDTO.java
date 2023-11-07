package com.example.university.pl.models;

import com.example.university.dal.models.Course;
import com.example.university.dal.models.Section;
import com.example.university.dal.models.Student;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;
    private String login;
    private String password;
    private boolean enabled;

    private double yearResult;
    private Section section;
    private List<Course> courses;
    private Section delegateSection;

    public static StudentDTO fromEntity(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .birthDate(student.getBirthDate())
                .email(student.getEmail())
                .login(student.getUsername())
                .password(student.getPassword())
                .enabled(student.isEnabled())
                .yearResult(student.getYearResult())
                .section(student.getSection())
                .courses(student.getCourses())
                .delegateSection(student.getDelegateSection())
                .build();
    }
}
