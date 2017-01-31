package com.akshay.validator;



import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class ItemValidator {
	public void validateSave(Item item) throws ItemNotFoundException {
		
		if ("".equals(item.getItemName())||"".equals(item.getId())||"".equals(item.getCategoryCode())||"".equals(item.getItemClosingStock())||"".equals(item.getItemOpeningStock())||"".equals(item.getItemStockOnHand())) {
		
				throw new ItemNotFoundException("Please fill all fields.");
			

		}
	
	}
	

}
