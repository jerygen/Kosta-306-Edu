package com.ws03.exception;

public class UserAccountNotFoundException extends Exception {
	public UserAccountNotFoundException() {}
	public UserAccountNotFoundException(String message) {
		super(message);
	}
	
}
