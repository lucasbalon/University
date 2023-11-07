package com.example.university.bll;

import com.example.university.dal.models.Professor;
import com.example.university.dal.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    @Override
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor updateProfessor(Long id, Professor professor) {
        Professor existingProfessor = getProfessorById(id);
        existingProfessor.setName(professor.getName());
        existingProfessor.setSurname(professor.getSurname());
        existingProfessor.setBirthDate(professor.getBirthDate());
        existingProfessor.setEmail(professor.getEmail());
        existingProfessor.setLogin(professor.getLogin());
        existingProfessor.setPassword(professor.getPassword());
        existingProfessor.setEnabled(professor.isEnabled());
        existingProfessor.setRoles(professor.getRoles());
        existingProfessor.setOffice(professor.getOffice());
        existingProfessor.setHireDate(professor.getHireDate());
        existingProfessor.setWage(professor.getWage());
        existingProfessor.setCourses(professor.getCourses());
        existingProfessor.setSection(professor.getSection());
        return professorRepository.save(existingProfessor);
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public void deleteProfessor(Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
