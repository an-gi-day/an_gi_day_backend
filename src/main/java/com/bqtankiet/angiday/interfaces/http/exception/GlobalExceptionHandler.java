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
        String message = "Error caused by UnsupportedOperationException";
        ApiResponse<?> response = ApiResponse.errorWithMessage(HttpStatus.NOT_FOUND.value(), message ,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleUnsupportedException(EntityNotFoundException exception) {
        String message = "Error caused by EntityNotFoundException";
        ApiResponse<?> response = ApiResponse.errorWithMessage(HttpStatus.NOT_FOUND.value(), message ,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
