package com.example.university.bll;

import com.example.university.dal.models.Course;
import com.example.university.dal.models.Professor;

import java.util.List;

public interface ProfessorService {
    Professor createProfessor(Professor professor);
    Professor updateProfessor(Long id, Professor professor);
    Professor getProfessorById(Long id);
    List<Professor> getAllProfessors();
    void deleteProfessor(Long id);
}
