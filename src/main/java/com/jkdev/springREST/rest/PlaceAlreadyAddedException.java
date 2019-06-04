package com.jkdev.springREST.rest;

public class PlaceAlreadyAddedException extends RuntimeException {

    public PlaceAlreadyAddedException() {
    }

    PlaceAlreadyAddedException(String message) {
        super(message);
    }

    public PlaceAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaceAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public PlaceAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
