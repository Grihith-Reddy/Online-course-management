package io.github.grihithreddy.onlinecoursemanagement.course.exceptions;

/**
 * Exception thrown when a course is not found in the system.
 * This class extends {@link RuntimeException} to indicate that it is an unchecked exception.
 */
public class CourseNotFoundException extends RuntimeException {

  /**
   * Constructor to create a new CourseNotFoundException with a custom message.
   *
   * @param message the detail message about the course not found
   */
  public CourseNotFoundException(String message) {
    super(message);
  }
}
