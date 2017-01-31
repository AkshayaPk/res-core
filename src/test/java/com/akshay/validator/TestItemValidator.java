package com.akshay.validator;

import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class TestItemValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item = new Item();
		item.setItemName("");
		ItemValidator itemValidator = new ItemValidator();
		try {
			itemValidator.validateSave(item);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
