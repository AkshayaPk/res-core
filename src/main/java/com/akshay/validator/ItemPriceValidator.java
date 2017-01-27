package com.akshay.validator;

import com.akshay.exception.ItemPriceInvalidUpdateException;
import com.akshay.model.ItemPrice;

public class ItemPriceValidator {
    
	public void validateUpdate(ItemPrice itemPrice)
	{
		if(itemPrice.getPrice()<0)
		{
			try {
				throw new ItemPriceInvalidUpdateException("Enter a valid price for the item");
			} catch (ItemPriceInvalidUpdateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
