package com.luv2code.springdemo.rest;

public class PlaceNotFoundException extends RuntimeException {

	public PlaceNotFoundException() {
	}

	public PlaceNotFoundException(String message) {
		super(message);
	}

	public PlaceNotFoundException(Throwable cause) {
		super(cause);
	}

	public PlaceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlaceNotFoundException(String message, Throwable cause, boolean enableSuppression,
								  boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
