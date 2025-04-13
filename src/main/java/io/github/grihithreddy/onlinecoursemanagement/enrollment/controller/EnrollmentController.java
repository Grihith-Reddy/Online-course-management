package io.github.grihithreddy.onlinecoursemanagement.enrollment.controller;

import io.github.grihithreddy.onlinecoursemanagement.enrollment.exception.EnrollmentAlreadyExistsException;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.Enrollment;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    /**
     * @param enrollmentService
     */
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        try {
            Enrollment newEnrollment = enrollmentService.enrollUser(enrollment);
            return new ResponseEntity<>(newEnrollment, HttpStatus.CREATED);
        } catch (EnrollmentAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Enrollment>> getUserEnrollments(@PathVariable String userId) {
        List<Enrollment> enrollments = enrollmentService.getUserEnrollments(userId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getCourseEnrollments(@PathVariable String courseId) {
        List<Enrollment> enrollments = enrollmentService.getCourseEnrollments(courseId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @PatchMapping("/{enrollmentId}/status")
    public ResponseEntity<Enrollment> updateEnrollmentStatus(
            @PathVariable Long enrollmentId,
            @RequestParam String status) {
        Enrollment enrollment = enrollmentService.updateEnrollmentStatus(enrollmentId, status);
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> cancelEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.cancelEnrollment(enrollmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}