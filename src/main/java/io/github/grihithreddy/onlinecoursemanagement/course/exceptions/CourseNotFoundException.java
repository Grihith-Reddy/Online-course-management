package io.github.grihithreddy.onlinecoursemanagement.course.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException(String message) {
    super(message);
  }
}
