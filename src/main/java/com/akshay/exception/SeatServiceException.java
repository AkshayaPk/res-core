package com.akshay.exception;

public class SeatServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeatServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeatServiceException(String message) {
		super(message);
	}

}
