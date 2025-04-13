package io.github.grihithreddy.onlinecoursemanagement.enrollment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class EnrollmentProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "id is required")
    private long id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    private boolean completed;

    private LocalDateTime completedTime;

    private LocalDateTime issueddate;

    public EnrollmentProgress() {
    }

    public EnrollmentProgress(long id, Enrollment enrollment, boolean completed, LocalDateTime completedTime, LocalDateTime issueddate) {
        this.id = id;
        this.enrollment = enrollment;
        this.completed = completed;
        this.completedTime = completedTime;
        this.issueddate = issueddate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentProgress that = (EnrollmentProgress) o;
        return id == that.id && completed == that.completed && Objects.equals(enrollment, that.enrollment) && Objects.equals(completedTime, that.completedTime) && Objects.equals(issueddate, that.issueddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enrollment, completed, completedTime, issueddate);
    }

    @Override
    public String toString() {
        return "EnrollmentProgress{" +
                "id=" + id +
                ", enrollments=" + enrollment +
                ", completed=" + completed +
                ", completedTime=" + completedTime +
                ", issueddate=" + issueddate +
                '}';
    }

    public void setEnrollment(Enrollment enrollment) {
    }

    public void setIssueddate(LocalDateTime now) {
    }

    public void setCompleted(boolean completed) {
    }

    public void setCompletedTime(LocalDateTime now) {
    }
}
