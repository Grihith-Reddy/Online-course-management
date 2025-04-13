package io.github.grihithreddy.onlinecoursemanagement.enrollment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="Enrollment")
public class Enrollment {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @NotBlank(message = "id is required")
       private long id;

       @Id
       @Column(nullable = false)
       @NotBlank(message="user id is required")
       private String userId;

      @Id
      @Column(nullable = false)
      @NotBlank(message="user name is required")
       private String username;

      @Id
       @Column(nullable = false)
       @Size(min=10,max=100)
       @NotBlank(message="courseId is required")
       private String courseId;

     @Column(nullable = false)
     @Size(min=10,max=100)
     @NotBlank(message="courseId is required")
       private String courseName;

       @Column(nullable = false)
       @NotBlank(message = "enrollmentdate is required")
       private LocalDateTime enrollmentTime;

       @Column(nullable = false)
       @NotBlank(message = "status is required")
       private String status;

       @Column(nullable = false)
       @Size(min=10,max=100)
       private String description;

    public Enrollment() {
    }

    public Enrollment(long id, String userId, String username, String courseId, String courseName, LocalDateTime enrollmentTime, String status, String description) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrollmentTime = enrollmentTime;
        this.status = status;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getEnrollmentTime() {
        return enrollmentTime;
    }

    public void setEnrollmentTime(LocalDateTime enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return id == that.id && Objects.equals(userId, that.userId) && Objects.equals(username, that.username) && Objects.equals(courseId, that.courseId) && Objects.equals(courseName, that.courseName) && Objects.equals(enrollmentTime, that.enrollmentTime) && Objects.equals(status, that.status) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, username, courseId, courseName, enrollmentTime, status, description);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", enrollmentTime=" + enrollmentTime +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }
}
