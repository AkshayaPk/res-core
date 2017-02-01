package com.akshay.service;

import com.akshay.dao.ItemPriceDAO;
import com.akshay.exception.ItemPriceInvalidUpdateException;
import com.akshay.exception.ItemPriceServiceException;
import com.akshay.model.ItemPrice;
import com.akshay.validator.ItemPriceValidator;

public class ItemPriceService {

	public void provideService(ItemPrice itemPrice) throws ItemPriceServiceException {
		ItemPriceValidator itemPriceValidator = new ItemPriceValidator();
		ItemPriceDAO itemPriceDAO = new ItemPriceDAO();
		try {
			itemPriceValidator.validateSave(itemPrice);
			itemPriceDAO.save(itemPrice);
		} catch (ItemPriceInvalidUpdateException e) {
			throw new ItemPriceServiceException("All fields must be entered",e);
		}
	}

	public void updateService(ItemPrice itemPrice) throws ItemPriceServiceException {
		ItemPriceValidator itemPriceValidator = new ItemPriceValidator();
		ItemPriceDAO itemPriceDAO = new ItemPriceDAO();

		try {
			itemPriceValidator.validateUpdate(itemPrice);
			itemPriceDAO.update(itemPrice);
		} catch (ItemPriceInvalidUpdateException e) {
			throw new ItemPriceServiceException("Update price without negative values",e);
		}
	}

	public void deleteService(ItemPrice itemPrice) throws ItemPriceServiceException {
		ItemPriceValidator itemPriceValidator = new ItemPriceValidator();
		ItemPriceDAO itemPriceDAO = new ItemPriceDAO();

		try {
			itemPriceValidator.validateDelete(itemPrice);
			itemPriceDAO.delete(itemPrice);
		} catch (ItemPriceInvalidUpdateException e) {
			throw new ItemPriceServiceException("Enter positive values alone",e);
		}
	}
}
