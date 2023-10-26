package ru.crystal.qrservice.exception;

/**
 * @project QRService
 * ©Crystal2033
 * @date 19/10/2023
 */

/**
 * Название метода get[name] == название поля name в ResponseBody
 * Например, если метод, возвращающий message будет называться getMyMessage,
 * то поле будет myMessage в ResponseBody
 */
public class ErrorInfo {
    private int statusCode;
    private String message;

    public int getStatus() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorInfo() {
    }

    public ErrorInfo(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
