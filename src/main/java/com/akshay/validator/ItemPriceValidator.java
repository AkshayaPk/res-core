package com.akshay.validator;

import com.akshay.exception.ItemPriceInvalidUpdateException;
import com.akshay.model.ItemPrice;

public class ItemPriceValidator {

	public void validateUpdate(ItemPrice itemPrice) throws ItemPriceInvalidUpdateException {

		if (itemPrice.getPrice() < 0 || itemPrice.getId() < 0 ) {

			throw new ItemPriceInvalidUpdateException("Enter a valid price for the item");

		}

	}

	public void validateSave(ItemPrice itemPrice) throws ItemPriceInvalidUpdateException {
		if ("".equals(itemPrice.getItemName())) {

			throw new ItemPriceInvalidUpdateException("This field cannot be null");

		}

	}
	public void validateDelete(ItemPrice itemPrice) throws ItemPriceInvalidUpdateException
	{
		if(itemPrice.getId()<0)
		{
			throw new ItemPriceInvalidUpdateException("Enter ID");
		}
	}
}
