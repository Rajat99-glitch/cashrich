package com.cashrich.exceptions;

public class UserNameNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserNameNotFoundException(String msg) {
		super(msg);
	}

}
