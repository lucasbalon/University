package com.example.university.pl.controller;

import com.example.university.bll.ProfessorService;
import com.example.university.dal.models.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }
    @GetMapping("/professors")
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }
    @GetMapping("/professors/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }
    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }
    @PutMapping("/professors/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        return professorService.updateProfessor(id, professor);
    }
    @DeleteMapping("/professors/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
}
