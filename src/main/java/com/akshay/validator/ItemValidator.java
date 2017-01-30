package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class ItemValidator {
	private final Logger logger = Logger.getLogger(ItemValidator.class.getName());
	public boolean validateSave(Item item) {
		
		if ("".equals(item.getItemName())||"".equals(item.getId())||"".equals(item.getCategoryCode())||"".equals(item.getItemClosingStock())||"".equals(item.getItemOpeningStock())||"".equals(item.getItemStockOnHand())) {
			try {
				throw new ItemNotFoundException("Please fill all fields.");
			} catch (ItemNotFoundException e) {
				
				logger.log(Level.SEVERE, "Exceptions Happen",e);
			}

		}
		return true;
	}
	

}
