package io.github.grihithreddy.onlinecoursemanagement.course.repository;

import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on the Course entity.
 * Extends JpaRepository to provide built-in methods for data persistence.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    /**
     * Retrieves a course by its unique ID.
     *
     * @param id the ID of the course
     * @return an Optional containing the course if found, otherwise empty
     */
    Optional<Course> findById(int id);

    /**
     * Retrieves a list of courses with a matching title.
     *
     * @param courseName the title of the course to search for
     * @return a list of courses with the exact title
     */
    List<Course> findByTitle(String courseName);

    /**
     * Retrieves a list of courses with a title containing the given text.
     *
     * @param courseName the text to search for in the course title
     * @return a list of courses with titles containing the given text
     */
    List<Course> findByTitleContaining(String courseName);

    /**
     * Retrieves a list of courses with a duration between the specified range.
     * The results are ordered by duration in ascending order.
     *
     * @param start the start of the duration range
     * @param end the end of the duration range
     * @return a list of courses with a duration within the specified range
     */
    @Query("SELECT c FROM Course c WHERE c.duration BETWEEN ?1 AND ?2 ORDER BY c.duration ASC ")
    List<Course> findByDurationBetween(int start, int end);
}
