package ru.crystal.qrservice.exception;

/**
 * @project QRService
 * ©Crystal2033
 * @date 23/10/2023
 */
public class SaveDataException extends RuntimeException{
    public SaveDataException(String message){
        super(message);
    }
}
