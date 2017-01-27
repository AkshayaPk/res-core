package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.ItemPriceInvalidUpdateException;
import com.akshay.model.ItemPrice;

public class ItemPriceValidator {
	 private final Logger logger = Logger.getLogger(ItemPriceValidator.class.getName());
	public void validateUpdate(ItemPrice itemPrice)
	{
		
		if(itemPrice.getPrice()<0)
		{
			try {
				throw new ItemPriceInvalidUpdateException("Enter a valid price for the item");
			} catch (ItemPriceInvalidUpdateException e) {
				
				logger.log(Level.SEVERE, "Exceptions Happen",e);
			}
		}
	}
}