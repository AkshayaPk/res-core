package com.akshay.validator;

import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class ItemValidator {

	public void validateSave(Item item) {
		if ("".equals(item.getItemName())) {
			try {
				throw new ItemNotFoundException("Item not in list");
			} catch (ItemNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	

}
