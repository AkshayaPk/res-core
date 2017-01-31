package com.akshay.service;

import com.akshay.dao.ItemDAO;
import com.akshay.exception.ItemNotFoundException;
import com.akshay.exception.ItemServiceException;
import com.akshay.model.Item;

import com.akshay.validator.ItemValidator;

public class ItemService {

	public void provideService(Item item) throws ItemServiceException {
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();
		
		try{
			itemValidator.validateSave(item);
			itemValidator.validateUpdate(item);
			itemDAO.save(item);
		}
		catch(ItemNotFoundException e)
		{
			throw new ItemServiceException("All fields must be entered");
		}
	}
	public void updateService(Item item) throws ItemServiceException
	{
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();
		
		try {
			itemValidator.validateSave(item);
			itemValidator.validateUpdate(item);
			itemDAO.update(item);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ItemServiceException("All fields must be entered");
		}
	}
	public void deleteService(Item item) throws ItemServiceException
	{
		ItemValidator itemValidator = new ItemValidator();
		ItemDAO itemDAO = new ItemDAO();
		
		try {
			itemValidator.validateSave(item);
			itemValidator.validateUpdate(item);
			itemDAO.delete(item);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ItemServiceException("All fields must be entered");
		}
	}
}
