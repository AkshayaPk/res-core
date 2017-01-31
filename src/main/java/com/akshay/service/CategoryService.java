package com.akshay.service;

import com.akshay.dao.CategoryDAO;
import com.akshay.exception.CategoryNotFoundException;
import com.akshay.exception.CategoryServiceException;
import com.akshay.model.Category;
import com.akshay.validator.CategoryValidator;

public class CategoryService {

	public void saveService(Category category) throws CategoryServiceException {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			categoryValidator.validateSave(category);
			categoryDAO.save(category);

		} catch (CategoryNotFoundException e) {

			throw new CategoryServiceException("All fields must be entered");
		}

	}

}
