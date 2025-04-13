package io.github.grihithreddy.onlinecoursemanagement.course.service;

import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseValidationException;
import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import io.github.grihithreddy.onlinecoursemanagement.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing courses in the database.
 * Implements the methods defined in the CourseService interface.
 */
@Service
public class DatabaseCourseService implements CourseService {

    private final CourseRepository courseRepository;

    /**
     * Constructor to initialize the DatabaseCourseService with a CourseRepository instance.
     *
     * @param courseRepository the repository to interact with the database
     */
    @Autowired
    public DatabaseCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Creates a new course.
     *
     * @param course the course to be created
     * @return the created Course object
     * @throws CourseValidationException if the course is null
     */
    @Override
    public Course createCourse(Course course) {
        if (course == null) {
            throw new CourseValidationException("Course cannot be null");
        }
        return courseRepository.save(course);
    }

    /**
     * Retrieves all available courses.
     *
     * @return list of all courses
     * @throws CourseNotFoundException if no courses are found
     */
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("Course not found");
        }
        return courses;
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param id the ID of the course to retrieve
     * @return the course with the specified ID
     * @throws CourseNotFoundException if the course is not found with the given ID
     */
    @Override
    public Course getCourseById(int id) throws CourseNotFoundException {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));
    }

    /**
     * Updates the title of an existing course.
     *
     * @param id the ID of the course to update
     * @param newTitle the new title for the course
     * @return the updated Course object
     * @throws CourseValidationException if the new title is invalid
     * @throws CourseNotFoundException if the course with the given ID does not exist
     */
    @Override
    public Course updateCourseTitle(int id, String newTitle) throws CourseValidationException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));

        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new CourseValidationException("Title cannot be empty");
        }

        course.setTitle(newTitle);
        return courseRepository.save(course);
    }

    /**
     * Updates the description of an existing course.
     *
     * @param id the ID of the course to update
     * @param newDescription the new description for the course
     * @return the updated Course object
     * @throws CourseValidationException if the new description is invalid
     * @throws CourseNotFoundException if the course with the given ID does not exist
     */
    @Override
    public Course updateCourseDescription(int id, String newDescription) throws CourseValidationException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));

        if (newDescription == null || newDescription.trim().isEmpty()) {
            throw new CourseValidationException("Description cannot be empty");
        }

        course.setDescription(newDescription);
        return courseRepository.save(course);
    }

    /**
     * Updates the duration of an existing course.
     *
     * @param id the ID of the course to update
     * @param newDuration the new duration for the course
     * @return the updated Course object
     * @throws CourseValidationException if the new duration is invalid
     * @throws CourseNotFoundException if the course with the given ID does not exist
     */
    @Override
    public Course updateCourseDuration(int id, String newDuration) throws CourseValidationException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));

        if (newDuration == null || newDuration.trim().isEmpty()) {
            throw new CourseValidationException("Duration cannot be empty");
        }

        course.setDuration(newDuration);
        return courseRepository.save(course);
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to delete
     * @return true if the course was deleted successfully
     * @throws CourseNotFoundException if the course with the given ID does not exist
     */
    @Override
    public boolean deleteCourse(int id) throws CourseNotFoundException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));

        courseRepository.delete(course);
        return true;
    }
}
