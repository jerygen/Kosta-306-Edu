package com.ws07.exception;

public class UserAccountNotFoundException extends Exception {
	public UserAccountNotFoundException() {System.out.println("사용자 또는 계좌를 찾을 수 없습니다.");}
	public UserAccountNotFoundException(String message) {
		super(message);
	}
	
}
