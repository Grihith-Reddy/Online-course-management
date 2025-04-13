package io.github.grihithreddy.onlinecoursemanagement.course.service;
import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.course.exceptions.CourseValidationException;
import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course)throws CourseValidationException;

    List<Course> getAllCourses() throws CourseNotFoundException;

    Course getCourseById(int id)throws CourseNotFoundException;

    Course updateCourseTitle(int id, String newTitle) throws CourseValidationException;

    Course updateCourseDescription(int id, String newDescription) throws CourseValidationException;

    Course updateCourseDuration(int id, String newDuration) throws CourseValidationException;

    boolean deleteCourse(int id) throws CourseNotFoundException;
}
