package com.scaler.BookMyShow.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException() {
    }
}
