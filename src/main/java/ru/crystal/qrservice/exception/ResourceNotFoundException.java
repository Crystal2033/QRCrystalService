package ru.crystal.qrservice.exception;

/**
 * @project QRService
 * ©Crystal2033
 * @date 19/10/2023
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
