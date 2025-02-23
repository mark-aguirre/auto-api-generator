package com.virtual.autoapigenerator.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private ResponseEntity<ErrorResponse> createErrorResponse(Exception ex, HttpStatus status, String errorType, String path) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String message = ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse(timestamp, errorType, message, path, status.value());
        return new ResponseEntity<>(errorResponse, status);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        String path = getRequestPath(); // Implement this method (see below)
        return createErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", path);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String path = getRequestPath(); // Implement this method (see below)

        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        // For validation errors, you might want a more structured error message.
        String message = "Validation failed for some fields: " + errors.toString(); // Or customize as needed.

        return createErrorResponse(new Exception(message), HttpStatus.BAD_REQUEST, "Validation Error", path); // Wrap in Exception for consistency.
    }


    // Helper class for the error response
    @Getter
    @Setter
    @AllArgsConstructor
    public static class ErrorResponse {
        private String timestamp;
        private String errorType;
        private String message;
        private String path;
        private int status;

    }




    private String getRequestPath() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            if (request != null) {
                return request.getRequestURI();
            }
        }

        return "Unknown Path";
    }
}