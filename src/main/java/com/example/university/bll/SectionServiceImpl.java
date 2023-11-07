package com.example.university.bll;

import com.example.university.dal.models.Section;
import com.example.university.dal.repositories.SectionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService{
    SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    @Override
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section updateSection(Long id, Section section) {
        Section existingSection = getSectionById(id);
        existingSection.setDelegate(section.getDelegate());
        existingSection.setProfessor(section.getProfessor());
        existingSection.setSectionName(section.getSectionName());
        existingSection.setStudents(section.getStudents());
        return sectionRepository.save(existingSection);
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void deleteSection(Long id) {
        if (sectionRepository.existsById(id)) {
            sectionRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
