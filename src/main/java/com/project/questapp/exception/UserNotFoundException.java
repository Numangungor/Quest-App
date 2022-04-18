package com.project.questapp.exception;


public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -939686463345095674L;
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String message) {
		super(message);
	}
}
