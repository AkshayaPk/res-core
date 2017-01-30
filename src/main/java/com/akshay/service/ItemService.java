package com.akshay.service;

import com.akshay.dao.ItemDAO;
import com.akshay.model.Item;

import com.akshay.validator.ItemValidator;

public class ItemService {

	public void provideService(Item item) {
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();
		if (itemValidator.validateSave(item) == true) {
			itemDAO.save(item);
		}
	}
}
