package io.github.grihithreddy.onlinecoursemanagement.course.repository;

import io.github.grihithreddy.onlinecoursemanagement.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findById(int id);
    List<Course> findByCourseName(String courseName);
    List<Course> findByCourseNameContaining(String courseName);

    @Query("SELECT c FROM Course c WHERE c.duration BETWEEN ?1 AND ?2 ORDER BY c.duration ASC ")
    List<Course> findByDurationBetween(int start, int end);
}
