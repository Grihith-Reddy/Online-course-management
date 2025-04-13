package io.github.grihithreddy.onlinecoursemanagement.enrollment.controller;

import io.github.grihithreddy.onlinecoursemanagement.enrollment.model.EnrollmentProgress;
import io.github.grihithreddy.onlinecoursemanagement.enrollment.service.EnrollmentProgressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments/{enrollmentId}/progress")
public class EnrollmentProgressController {
    private final EnrollmentProgressService progressService;

    public EnrollmentProgressController(EnrollmentProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentProgress> createProgressRecord(
            @PathVariable Long enrollmentId,
            @RequestBody EnrollmentProgress progress) {
        EnrollmentProgress newProgress = progressService.createProgressRecord(enrollmentId, progress);
        return new ResponseEntity<>(newProgress, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentProgress>> getProgressRecords(
            @PathVariable Long enrollmentId) {
        List<EnrollmentProgress> progressRecords = progressService.getProgressRecords(enrollmentId);
        return new ResponseEntity<>(progressRecords, HttpStatus.OK);
    }

    @PatchMapping("/{progressId}/completion")
    public ResponseEntity<EnrollmentProgress> updateProgressCompletion(
            @PathVariable Long enrollmentId,
            @PathVariable Long progressId,
            @RequestParam boolean completed) {
        EnrollmentProgress progress = progressService.updateProgressCompletion(enrollmentId, progressId, completed);
        return new ResponseEntity<>(progress, HttpStatus.OK);
    }
}