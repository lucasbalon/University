package com.example.university.pl.models;

import com.example.university.dal.models.Professor;
import com.example.university.dal.models.Section;
import com.example.university.dal.models.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SectionDTO {
    private Long id;
    private String sectionName;
    private List<Professor> professor;
    private List<Student> students;
    private Student delegate;


    public static SectionDTO fromEntity(Section section) {
        return SectionDTO.builder()
                    .id(section.getId())
                    .sectionName(section.getSectionName())
                    .professor(section.getProfessor())
                    .students(section.getStudents())
                    .delegate(section.getDelegate())
                    .build();
    }
}
