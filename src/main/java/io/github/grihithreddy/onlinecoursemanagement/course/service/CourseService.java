package io.github.grihithreddy.onlinecoursemanagement.course.service;

import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseValidationException;
import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;

import java.util.List;

/**
 * Interface that defines operations for managing Course entities.
 * Includes creation, retrieval, update, and deletion methods.
 */
public interface CourseService {

    /**
     * Creates a new course.
     *
     * @param course the course to be created
     * @return the created Course object
     * @throws CourseValidationException if validation of the course fails
     */
    Course createCourse(Course course) throws CourseValidationException;

    /**
     * Retrieves all available courses.
     *
     * @return list of all courses
     * @throws CourseNotFoundException if no courses are found
     */
    List<Course> getAllCourses() throws CourseNotFoundException;

    /**
     * Retrieves a course by its unique ID.
     *
     * @param id the ID of the course
     * @return the Course with the given ID
     * @throws CourseNotFoundException if no course is found with the given ID
     */
    Course getCourseById(int id) throws CourseNotFoundException;

    /**
     * Updates the title of a course.
     *
     * @param id the ID of the course to update
     * @param newTitle the new title to set
     * @return the updated Course object
     * @throws CourseValidationException if the new title is invalid
     */
    Course updateCourseTitle(int id, String newTitle) throws CourseValidationException;

    /**
     * Updates the description of a course.
     *
     * @param id the ID of the course to update
     * @param newDescription the new description to set
     * @return the updated Course object
     * @throws CourseValidationException if the new description is invalid
     */
    Course updateCourseDescription(int id, String newDescription) throws CourseValidationException;

    /**
     * Updates the duration of a course.
     *
     * @param id the ID of the course to update
     * @param newDuration the new duration to set
     * @return the updated Course object
     * @throws CourseValidationException if the new duration is invalid
     */
    Course updateCourseDuration(int id, String newDuration) throws CourseValidationException;

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to delete
     * @return true if deletion was successful, false otherwise
     * @throws CourseNotFoundException if no course is found with the given ID
     */
    boolean deleteCourse(int id) throws CourseNotFoundException;
}
