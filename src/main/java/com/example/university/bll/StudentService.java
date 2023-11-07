package com.example.university.bll;

import com.example.university.dal.models.Section;
import com.example.university.dal.models.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    void deleteStudent(Long id);
}
