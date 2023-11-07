package com.example.university.pl.models;

import com.example.university.dal.models.Course;
import com.example.university.dal.models.Professor;
import com.example.university.dal.models.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseDTO {
    private String courseId;

    private String courseName;

    private int courseEcts;

    private Professor professor;

    private List<Student> students;

    public static CourseDTO fromEntity(Course course) {
        return CourseDTO.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseEcts(course.getCourseEcts())
                .professor(course.getProfessor())
                .students(course.getStudents())
                .build();
    }
}
