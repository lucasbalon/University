package com.example.university.pl.controller;

import com.example.university.bll.SectionService;
import com.example.university.dal.models.Section;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }
    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }
    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionService.createSection(section);
    }
    @PutMapping("/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section section) {
        return sectionService.updateSection(id, section);
    }
    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
    }
}
