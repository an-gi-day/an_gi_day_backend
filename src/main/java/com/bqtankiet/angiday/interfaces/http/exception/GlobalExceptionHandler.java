package com.bqtankiet.angiday.interfaces.http.exception;

import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ApiResponse<?>> handleUnsupportedException(UnsupportedOperationException exception) {
        String error = "Error caused by " + exception.getClass().getSimpleName();
        String message = exception.getMessage();
        ApiResponse<?> response = ApiResponse.errorWithMessage(HttpStatus.NOT_FOUND.value(), message, error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleUnsupportedException(EntityNotFoundException exception) {
        String error = "Error caused by " + exception.getClass().getSimpleName();
        String message = exception.getMessage();
        ApiResponse<?> response = ApiResponse.errorWithMessage(HttpStatus.NOT_FOUND.value(), message, error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
