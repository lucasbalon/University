package com.example.university.bll;

import com.example.university.dal.models.Professor;
import com.example.university.dal.models.Section;

import java.util.List;

public interface SectionService {
    Section createSection(Section section);
    Section updateSection(Long id, Section section);
    Section getSectionById(Long id);
    List<Section> getAllSections();
    void deleteSection(Long id);
}
