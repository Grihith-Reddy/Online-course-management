package io.github.grihithreddy.onlinecoursemanagement.user.exception;

import io.github.grihithreddy.onlinecoursemanagement.user.exception.UserNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.user.exception.UserValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Global exception handler for User-related operations.
 */
@ControllerAdvice
public class UserGlobalExceptionHandler {
    /**
     * Handles UserNotFoundException and returns a 404 Not Found response.
     *
     * @param exception The exception that was thrown (UserNotFoundException).
     * @return A ResponseEntity of ErrorResponse with error details.
     */

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                "User Not Found",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    /**
     * Handles UserValidationException and returns a 400 Bad Request response.
     *
     * @param exception The exception that was thrown (UserValidationException).
     * @return A ResponseEntity of ErrorResponse with error details.
     */

    @ExceptionHandler(value = UserValidationException.class)
    public ResponseEntity<ErrorResponse> handleUserValidationException(UserValidationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                "User Validation Error",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    /**
     * Handles UserValidationException and returns a 400 Bad Request response.
     *
     * @param exception The exception that was thrown (UserValidationException).
     * @return A ResponseEntity of ErrorResponse with error details.
     */

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                "Validation Error",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    /**
     * Fallback exception handler for all other exceptions.
     * @param exception The exception that was thrown.
     * @return ResponseEntity with generic error details.
     */

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                "Internal Server Error",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Error response structure with timestamp, status, message and details.
     */

    private record ErrorResponse(int status, LocalDateTime timestamp, String message, String details) {
    }
}
