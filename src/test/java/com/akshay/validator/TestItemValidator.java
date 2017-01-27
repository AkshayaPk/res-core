package com.akshay.validator;

import com.akshay.model.Item;

public class TestItemValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item = new Item();
		item.setItemName("");
		ItemValidator itemValidator = new ItemValidator();
		itemValidator.validateSave(item);

	}

}
