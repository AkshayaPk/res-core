package com.akshay.service;

import com.akshay.dao.CategoryDAO;
import com.akshay.model.Category;
import com.akshay.validator.CategoryValidator;

public class CategoryService {
        
	public void provideService(Category category)
	{
		CategoryValidator categoryValidator=new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();
		if(categoryValidator.validateSave(category)==true)
		{
			categoryDAO.save(category);
		}
	}
	
}
