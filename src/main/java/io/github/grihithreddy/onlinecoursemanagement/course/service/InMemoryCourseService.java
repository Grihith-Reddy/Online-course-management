package io.github.grihithreddy.onlinecoursemanagement.course.service;

import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing courses in memory.
 * This class provides basic CRUD operations for courses using an in-memory list.
 */
@Service
public class InMemoryCourseService {

    private final List<Course> courses;

    /**
     * Constructor to initialize the InMemoryCourseService with an empty list of courses.
     */
    public InMemoryCourseService() {
        this.courses = new ArrayList<>();
    }

    /**
     * Creates a new course and adds it to the in-memory list.
     *
     * @param course the course to be created
     * @return the created Course object
     */
    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    /**
     * Retrieves all the courses stored in memory.
     *
     * @return list of all courses
     */
    public List<Course> getAllCourses() {
        return courses;
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param id the ID of the course to retrieve
     * @return the course with the specified ID, or null if not found
     */
    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    /**
     * Updates the title of an existing course.
     *
     * @param id the ID of the course to update
     * @param newTitle the new title for the course
     * @return the updated Course object, or null if the course is not found
     */
    public Course updateCourseTitle(int id, String newTitle) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setTitle(newTitle);
        }
        return course;
    }

    /**
     * Updates the description of an existing course.
     *
     * @param id the ID of the course to update
     * @param newDescription the new description for the course
     * @return the updated Course object, or null if the course is not found
     */
    public Course updateCourseDescription(int id, String newDescription) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setDescription(newDescription);
        }
        return course;
    }

    /**
     * Updates the duration of an existing course.
     *
     * @param id the ID of the course to update
     * @param newDuration the new duration for the course
     * @return the updated Course object, or null if the course is not found
     */
    public Course updateCourseDuration(int id, String newDuration) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setDuration(newDuration);
        }
        return course;
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to delete
     * @return true if the course was deleted successfully, false if not found
     */
    public boolean deleteCourse(int id) {
        Course course = getCourseById(id);
        if (course != null) {
            courses.remove(course);
            return true;
        }
        return false;
    }
}
