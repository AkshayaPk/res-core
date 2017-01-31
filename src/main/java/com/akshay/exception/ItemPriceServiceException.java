package com.akshay.exception;

public class ItemPriceServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemPriceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemPriceServiceException(String message) {
		super(message);
	}

}
