package io.github.grihithreddy.onlinecoursemanagement.course.controller;

import io.github.grihithreddy.onlinecoursemanagement.course.service.CourseService;
import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Validated
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(@Qualifier("databaseCourseService") CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Creates a new course.
     *
     * @param course The course information to create
     * @return The created course with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        Course created = courseService.createCourse(course);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Retrieves all courses from the system.
     *
     * @return ResponseEntity containing a list of all courses with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    /**
     * Retrieves a specific course by its ID.
     *
     * @param id the unique identifier of the course
     * @return ResponseEntity containing the course with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the course doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable @Positive int id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the title of a specific course.
     *
     * @param id    the unique identifier of the course to update
     * @param title the new title (must be between 5 and 50 characters)
     * @return ResponseEntity containing the updated course with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the course doesn't exist
     */
    @PutMapping("/{id}/title")
    public ResponseEntity<Course> updateCourseTitle(
            @PathVariable @Positive int id,
            @RequestParam @Size(min = 5, max = 50) String title
    ) {
        Course updated = courseService.updateCourseTitle(id, title);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the description of a specific course.
     *
     * @param id          the unique identifier of the course to update
     * @param description the new description (must be between 10 and 100 characters)
     * @return ResponseEntity containing the updated course with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the course doesn't exist
     */
    @PutMapping("/{id}/description")
    public ResponseEntity<Course> updateCourseDescription(
            @PathVariable @Positive int id,
            @RequestParam @Size(min = 10, max = 100) String description
    ) {
        Course updated = courseService.updateCourseDescription(id, description);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the duration of a specific course.
     *
     * @param id       the unique identifier of the course to update
     * @param duration the new duration
     * @return ResponseEntity containing the updated course with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the course doesn't exist
     */
    @PutMapping("/{id}/duration")
    public ResponseEntity<Course> updateCourseDuration(
            @PathVariable @Positive int id,
            @RequestParam String duration
    ) {
        Course updated = courseService.updateCourseDuration(id, duration);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a specific course from the system.
     *
     * @param id the unique identifier of the course to delete
     * @return ResponseEntity with a success message and HTTP status 200 (OK) if deleted,
     * or an error message and HTTP status 404 (Not Found) if the course doesn't exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable @Positive int id) {
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            return ResponseEntity.ok("Course deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
    }
}
