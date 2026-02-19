package com.ws03.exception;

public class BalanceLackException extends Exception {
	public BalanceLackException() {}
	public BalanceLackException(String message) {
		super(message);
	}
}
