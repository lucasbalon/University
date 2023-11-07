package com.example.university.bll;

import com.example.university.dal.models.Course;
import com.example.university.dal.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = getCourseById(id);
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setProfessor(course.getProfessor());
        existingCourse.setCourseEcts(course.getCourseEcts());
        existingCourse.setStudents(course.getStudents());
        return courseRepository.save(existingCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}