package io.github.grihithreddy.onlinecoursemanagement.enrollment.service;

import io.github.grihithreddy.onlinecoursemanagement.enrollment.exception.EnrollmentAlreadyExistsException;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.exception.ResourceNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.Enrollment;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment enrollUser(Enrollment enrollment) throws EnrollmentAlreadyExistsException {
        // Check if enrollment already exists
        if (enrollmentRepository.findByUserIdAndCourseId(
                enrollment.getUserId(),
                enrollment.getCourseId()).isPresent()) {
            throw new EnrollmentAlreadyExistsException("User is already enrolled in this course");
        }

        // Set enrollment time
        enrollment.setEnrollmentTime(LocalDateTime.now());
        // Set default status if not set
        if (enrollment.getStatus() == null) {
            enrollment.setStatus("ACTIVE");
        }

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getUserEnrollments(String userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    public List<Enrollment> getCourseEnrollments(String courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Enrollment updateEnrollmentStatus(Long enrollmentId, String status) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));

        enrollment.setStatus(status);
        return enrollmentRepository.save(enrollment);
    }

    public void cancelEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));

        enrollment.setStatus("CANCELLED");
        enrollmentRepository.save(enrollment);
    }
}