package io.github.grihithreddy.onlinecoursemanagement.enrollment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnrollmentValidationException extends RuntimeException {

    public EnrollmentValidationException(String message) {
        super(message);
    }
}