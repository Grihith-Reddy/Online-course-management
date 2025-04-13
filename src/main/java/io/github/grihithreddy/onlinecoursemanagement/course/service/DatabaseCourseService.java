package io.github.grihithreddy.onlinecoursemanagement.course.service;

import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseValidationException;
import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import io.github.grihithreddy.onlinecoursemanagement.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseCourseService implements CourseService {
    private final CourseRepository courseRepository;
    @Autowired public DatabaseCourseService(CourseRepository productRepository) {
        this.courseRepository = productRepository;
    }

    @Override
    public Course createCourse(Course course) {
        if (course == null) {
            throw new CourseValidationException("Course cannot be null");
        }
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
            if (courses.isEmpty()) {
                throw new CourseNotFoundException("Course not found");
            }
        return List.of();
    }

    @Override
    public Course getCourseById(int id) throws CourseNotFoundException {
        return null;
    }

    @Override
    public Course updateCourseTitle(int id, String newTitle) throws CourseValidationException {
        return null;
    }

    @Override
    public Course updateCourseDescription(int id, String newDescription) throws CourseValidationException {
        return null;
    }

    @Override
    public Course updateCourseDuration(int id, String newDuration) throws CourseValidationException {
        return null;
    }

    @Override
    public boolean deleteCourse(int id) throws CourseNotFoundException {
        return false;
    }
}
