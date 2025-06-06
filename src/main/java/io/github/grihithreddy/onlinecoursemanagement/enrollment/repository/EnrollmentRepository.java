package io.github.grihithreddy.onlinecoursemanagement.enrollment.repository;

import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByUserIdAndCourseId(String userId, String courseId);
    List<Enrollment> findByUserId(String userId);
    List<Enrollment> findByCourseId(String courseId);
}