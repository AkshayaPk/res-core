package com.akshay.exception;

public class SeatInvalidEntriesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeatInvalidEntriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeatInvalidEntriesException(String message) {
		super(message);
	}

}
