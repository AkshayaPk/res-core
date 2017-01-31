package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.CategoryNotFoundException;
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
	public void validateSave(ItemPrice itemPrice) throws ItemPriceInvalidUpdateException  {
		if("".equals(itemPrice.getId())||"".equals(itemPrice.getItemName())||"".equals(itemPrice.getPrice()))
		{
			
				throw new ItemPriceInvalidUpdateException("This field cannot be null");
			
		}
		
	}
}
