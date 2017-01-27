package com.akshay.exception;

public class ItemPriceInvalidUpdateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemPriceInvalidUpdateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ItemPriceInvalidUpdateException(String message) {
		super(message);
		
	}

}
