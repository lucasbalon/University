package com.example.university.pl.controller;

import com.example.university.bll.SectionService;
import com.example.university.dal.models.Section;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    @GetMapping("/sections")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }
    @GetMapping("/sections/{id}")
    public Section getSectionById(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }
    @PostMapping("/sections")
    public Section createSection(@RequestBody Section section) {
        return sectionService.createSection(section);
    }
    @PutMapping("/sections/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section section) {
        return sectionService.updateSection(id, section);
    }
    @DeleteMapping("/sections/{id}")
    public void deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
    }
}
