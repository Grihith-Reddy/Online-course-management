package io.github.grihithreddy.onlinecoursemanagement.enrollment.repository;

import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.EnrollmentProgress;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentProgressRepository extends JpaRepository<EnrollmentProgress, Long> {
    List<EnrollmentProgress> findByEnrollment(Enrollment enrollment);
    Optional<EnrollmentProgress> findByEnrollmentAndId(Enrollment enrollment, Long progressId);
}