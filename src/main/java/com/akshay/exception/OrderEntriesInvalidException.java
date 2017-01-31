package com.akshay.exception;

public class OrderEntriesInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderEntriesInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderEntriesInvalidException(String message) {
		super(message);
	}

}
