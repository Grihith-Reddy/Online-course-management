package io.github.grihithreddy.onlinecoursemanagement.course.service;
import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryCourseService {

    private final List<Course> courses;

    public InMemoryCourseService() {
        this.courses = new ArrayList<>();
    }

    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public Course updateCourseTitle(int id, String newTitle) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setTitle(newTitle);
        }
        return course;
    }

    public Course updateCourseDescription(int id, String newDescription) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setDescription(newDescription);
        }
        return course;
    }

    public Course updateCourseDuration(int id, String newDuration) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setDuration(newDuration);
        }
        return course;
    }

    public boolean deleteCourse(int id) {
        Course course = getCourseById(id);
        if (course != null) {
            courses.remove(course);
            return true;
        }
        return false;
    }
}
