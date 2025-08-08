package com.ifpr.thread.stilofit.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(
                        MethodArgumentNotValidException ex,
                        HttpServletRequest request) {

                log.error("Argument validation error:{}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.UNPROCESSABLE_ENTITY,
                                "Validation error occurred");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
        }
}