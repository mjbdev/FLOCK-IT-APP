package com.flockit.app.exception;

public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public LoginException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
