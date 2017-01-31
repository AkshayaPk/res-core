package com.akshay.exception;

public class OrderItemInvalidEntriesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemInvalidEntriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderItemInvalidEntriesException(String message) {
		super(message);
	}

}
