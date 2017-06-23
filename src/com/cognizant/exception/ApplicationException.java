package com.cognizant.exception;

public class ApplicationException extends Exception {
	public ApplicationException(final String  message) {
		super(message);
	}

	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

	public ApplicationException( final String message, final Throwable throwable) {
		super(message, throwable);
	}

}
