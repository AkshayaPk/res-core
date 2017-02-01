package com.akshay.service;

import com.akshay.dao.ItemDAO;
import com.akshay.exception.ItemNotFoundException;
import com.akshay.exception.ItemServiceException;
import com.akshay.model.Item;

import com.akshay.validator.ItemValidator;

public class ItemService {

	private static final String ALL_FIELDS_MUST_BE_ENTERED = "All fields must be entered";

	public void provideService(Item item) throws ItemServiceException {
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();

		try {
			itemValidator.validateSave(item);
			itemValidator.validateUpdate(item);
			itemDAO.save(item);
		} catch (ItemNotFoundException e) {
			throw new ItemServiceException(ALL_FIELDS_MUST_BE_ENTERED,e);
		}
	}

	public void updateService(Item item) throws ItemServiceException {
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();

		try {
			
			itemValidator.validateUpdate(item);
			itemDAO.update(item);
		} catch (ItemNotFoundException e) {
			throw new ItemServiceException(ALL_FIELDS_MUST_BE_ENTERED,e);
		}
	}

	public void deleteService(Item item) throws ItemServiceException {
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();

		try {
			itemValidator.validateDelete(item);
			itemDAO.delete(item);
		} catch (ItemNotFoundException e) {
		
			throw new ItemServiceException(ALL_FIELDS_MUST_BE_ENTERED,e);
		}
	}
}
