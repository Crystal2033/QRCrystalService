package ru.crystal.qrservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @project QRService
 * ©Crystal2033
 * @date 19/10/2023
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String reason) {
        super(reason);
    }
}
