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

                log.error("Erro de validação:{}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.UNPROCESSABLE_ENTITY,
                                "Ocorreu um erro de validação");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
        }

        @ExceptionHandler(CpfAlreadyRegisteredException.class)
        public ResponseEntity<ErrorMessage> handleCpfAlreadyRegistered(
                        CpfAlreadyRegisteredException ex,
                        HttpServletRequest request) {

                log.error("Conflito de CPF: {}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.CONFLICT,
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
}