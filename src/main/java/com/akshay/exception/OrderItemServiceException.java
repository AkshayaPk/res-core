package com.akshay.exception;

public class OrderItemServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderItemServiceException(String message) {
		super(message);
	}

}
