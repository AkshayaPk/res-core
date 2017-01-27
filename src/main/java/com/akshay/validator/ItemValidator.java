package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class ItemValidator {
	private static Logger logger = Logger.getLogger(ItemValidator.class.getName());
	public void validateSave(Item item) {
		if ("".equals(item.getItemName())) {
			try {
				throw new ItemNotFoundException("Item not in list");
			} catch (ItemNotFoundException e) {
				// TODO Auto-generated catch block
				logger.log(Level.SEVERE, "Exceptions Happen",e);
			}

		}
	}
	

}
