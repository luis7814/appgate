package com.appgate.operation.controller.exception;

import org.springframework.http.HttpStatus;

public class ValidateException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;
    private String code;

    public ValidateException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
