package com.crawler.app.usecase.exception;

public class InputValidationException extends RuntimeException {
	public InputValidationException(final String message) {
		super(message);
	}
}
