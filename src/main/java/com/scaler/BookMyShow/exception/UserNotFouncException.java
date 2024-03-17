package com.scaler.BookMyShow.exception;

public class UserNotFouncException extends RuntimeException{
    public UserNotFouncException(String message) {
        super(message);
    }

    public UserNotFouncException() {
    }
}
