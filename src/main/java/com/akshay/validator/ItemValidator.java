package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class ItemValidator {
	
	public void validateSave(Item item) {
		Logger logger = Logger.getLogger(ItemValidator.class.getName());
		if ("".equals(item.getItemName())) {
			try {
				throw new ItemNotFoundException("Item not in list");
			} catch (ItemNotFoundException e) {
				
				logger.log(Level.SEVERE, "Exceptions Happen",e);
			}

		}
	}
	

}
