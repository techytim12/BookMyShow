package com.scaler.BookMyShow.exception;

public class SeatNotAvailableException extends RuntimeException{
    public SeatNotAvailableException(String message) {
        super(message);
    }

    public SeatNotAvailableException() {
    }
}
