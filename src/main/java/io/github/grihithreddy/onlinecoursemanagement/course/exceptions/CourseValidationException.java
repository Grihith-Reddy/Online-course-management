package io.github.grihithreddy.onlinecoursemanagement.course.exceptions;

/**
 * Exception thrown when a validation error occurs during course processing.
 * This class extends {@link RuntimeException} to indicate that it is an unchecked exception.
 */
public class CourseValidationException extends RuntimeException {

    /**
     * Constructor to create a new CourseValidationException with a custom message.
     *
     * @param message the detail message about the validation error
     */
    public CourseValidationException(String message) {
        super(message);
    }
}
