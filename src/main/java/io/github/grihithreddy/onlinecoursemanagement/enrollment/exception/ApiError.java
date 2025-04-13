package io.github.grihithreddy.onlinecoursemanagement.enrollment.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class ApiError {
  private HttpStatus status;
  private String message;
  private LocalDateTime timestamp;

  public ApiError(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ApiError apiError = (ApiError) o;
    return status == apiError.status && Objects.equals(message, apiError.message) && Objects.equals(timestamp, apiError.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, timestamp);
  }

  @Override
  public String toString() {
    return "ApiError{" +
            "status=" + status +
            ", message='" + message + '\'' +
            ", timestamp=" + timestamp +
            '}';
  }
}
