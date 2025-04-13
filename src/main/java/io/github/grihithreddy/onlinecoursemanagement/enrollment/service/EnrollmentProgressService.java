package io.github.grihithreddy.onlinecoursemanagement.enrollment.service;

import io.github.grihithreddy.onlinecoursemanagement.enrollment.exception.ResourceNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.Enrollment;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.EnrollmentProgress;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.repository.EnrollmentProgressRepository;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentProgressService {
    private final EnrollmentProgressRepository progressRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentProgressService(EnrollmentProgressRepository progressRepository,
                                     EnrollmentRepository enrollmentRepository) {
        this.progressRepository = progressRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public EnrollmentProgress createProgressRecord(Long enrollmentId, EnrollmentProgress progress) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));

        progress.setEnrollment(enrollment);
        progress.setIssueddate(LocalDateTime.now());
        return progressRepository.save(progress);
    }

    public List<EnrollmentProgress> getProgressRecords(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));

        return progressRepository.findByEnrollment(enrollment);
    }

    public EnrollmentProgress updateProgressCompletion(Long enrollmentId, Long progressId, boolean completed) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));

        EnrollmentProgress progress = progressRepository.findByEnrollmentAndId(enrollment, progressId)
                .orElseThrow(() -> new ResourceNotFoundException("Progress record not found with id: " + progressId));

        progress.setCompleted(completed);
        if (completed) {
            progress.setCompletedTime(LocalDateTime.now());
        } else {
            progress.setCompletedTime(null);
        }

        return progressRepository.save(progress);
    }
}