package com.rmnorbert.VC.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String errorMessage = fieldErrors.stream()
                .map(fieldError -> fieldError.getField().toUpperCase() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));

        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException() {
        String errorMessage = "Invalid input value provided. Please provide a valid numeric value.";
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
