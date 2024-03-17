package com.scaler.BookMyShow.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException() {
    }
}
