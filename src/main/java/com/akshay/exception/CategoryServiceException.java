package com.akshay.exception;

public class CategoryServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoryServiceException(String message) {
		super(message);
	}

}
