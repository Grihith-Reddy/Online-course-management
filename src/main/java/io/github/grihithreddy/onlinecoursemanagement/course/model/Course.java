package io.github.grihithreddy.onlinecoursemanagement.course.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="courses")
public class Course {
    /**
     * The Id is auto generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    /**
     * This contains the title of the course and has a limit of 5-50 characters
     */
    @NotBlank()
    @Size(min=5, max=50,message = "Title should be between 5-50 characters")
    @Column(nullable=false)
    private String title;


    /**
     * This contains the description of the course and has the limit of 10-100 characters
     */
    @NotBlank()
    @Size(min=10, max=100,message="description should br between 10-50 characters")
    @Column(nullable=false)
    private String description;

    /**
     * Provides the date and time format
     */
    @NotBlank()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="Created_at")
    private LocalDate date;


    /**
     * has the duration of the course
     */
    @NotBlank(message="please provide the duration of the course")
    @Column(nullable=false)
    private String duration;


    /**
     * This automatically generates the today's date without any input
     */
    @PrePersist
    protected void onCreate() {
        this.date = LocalDate.now();
    }


    public Course() {
    }

    public Course(int id, String title, String description, LocalDate date, String duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id
                && Objects.equals(title, course.title)
                && Objects.equals(description, course.description)
                && Objects.equals(date, course.date)
                && Objects.equals(duration, course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, duration);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", duration='" + duration + '\'' +
                '}';
    }
}
