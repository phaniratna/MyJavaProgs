package com.demo.atm.exception;

public class ATMNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ATMNotFoundException(String message) {
		super(message);
	}

}
