package ru.crystal.qrservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @project QRService
 * ©Crystal2033
 * @date 19/10/2023
 */

/**
 * Or we can use @RestControllerAdvice without
 * @ControllerAdvice + ResponseEntity<ErrorInfo> -> ErrorInfo fields
 * @RestControllerAdvice + ResponseEntity<ErrorInfo> -> ErrorInfo fields
 * @ControllerAdvice + ErrorInfo -> ResponseEntity fields
 * @RestControllerAdvice + ErrorInfo -> ErrorInfo fields
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorInfo> catchResourceNotFoundException(ResourceNotFoundException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatusCode.valueOf(errorInfo.getStatus()));
    }

}
