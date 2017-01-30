package com.akshay.service;

import com.akshay.dao.ItemPriceDAO;
import com.akshay.model.ItemPrice;
import com.akshay.validator.ItemPriceValidator;

public class ItemPriceService {

	
	public void provideService(ItemPrice itemPrice)
	{
	 ItemPriceValidator itemPriceValidator = new ItemPriceValidator();
	 ItemPriceDAO itemPriceDAO=new ItemPriceDAO();
		if(itemPriceValidator.validateSave(itemPrice)==true)
		{
			itemPriceDAO.save(itemPrice);
		}
	}
}
