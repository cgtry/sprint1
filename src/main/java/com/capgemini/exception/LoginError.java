package com.capgemini.exception;

public class LoginError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoginError(String message) {
		this.message = message;
	}
	public LoginError() {
	}
	
}
