package com.akshay.service;

import com.akshay.dao.CategoryDAO;
import com.akshay.exception.CategoryNotFoundException;
import com.akshay.exception.CategoryServiceException;
import com.akshay.model.Category;
import com.akshay.validator.CategoryValidator;

public class CategoryService {

	private static final String ALL_FIELDS_MUST_BE_ENTERED = "All fields must be entered";

	public void saveService(Category category) throws CategoryServiceException  {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			categoryValidator.validateSave(category);
			categoryDAO.save(category);

		} catch (CategoryNotFoundException e) {

throw new CategoryServiceException("Enter all values",e);	
}

	}

	public void updateService(Category category) throws CategoryServiceException {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();

		try {
			categoryValidator.validateUpdate(category);
			categoryDAO.update(category);
		} catch (CategoryNotFoundException e) {
			throw new CategoryServiceException(ALL_FIELDS_MUST_BE_ENTERED,e);

		}

	}

	public void deleteService(Category category) throws CategoryServiceException {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();

		try {
			categoryValidator.validateDelete(category);
			categoryDAO.delete(category);
		} catch (CategoryNotFoundException e) {
			throw new CategoryServiceException(ALL_FIELDS_MUST_BE_ENTERED,e);

		}

	}

}
